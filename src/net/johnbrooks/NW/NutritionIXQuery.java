package net.johnbrooks.NW;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by john on 5/17/17.
 */
public class NutritionIXQuery
{
    public static NutritionIXItem getItem(String id)
    {
        NutritionIXQuery query = new NutritionIXQuery(NutritionIXQueryType.GET);
        query.addArgument(id);
        HttpResponse<JsonNode> node = query.runQuery();
        NutritionIXGetItemResponse response = new NutritionIXGetItemResponse(node);
        return response.getBodyDetails().getItem();
    }

    public static NutritionIXItem[] searchForItems(String keywords, NutritionIXField... fields)
    {
        NutritionIXQuery query = new NutritionIXQuery(NutritionIXQuery.NutritionIXQueryType.SEARCH);
        query.addArgument(keywords);
        for (NutritionIXField field : fields.length == 0 ? NutritionIXField.values() : fields)
            query.addField(field);
        HttpResponse<JsonNode> node = query.runQuery();
        NutritionIXSearchResponse response = new NutritionIXSearchResponse(node);
        return response.getBodyDetails().getItems();
    }

    private NutritionIXQueryType type;
    private String query;
    private String args;
    private String fields;

    public NutritionIXQuery(NutritionIXQueryType type)
    {
        setType(type);
    }

    public NutritionIXQuery addField(NutritionIXField field)
    {
        if (fields == "?fields=")
            fields += field;
        else
            fields += "%2C" + field;
        return this;
    }

    public NutritionIXQuery clearFields()
    {
        fields = "?fields=";
        return this;
    }

    /**
     * Add a new param/argument to the query.
     * @param arg
     * @return net.johnbrooks.NW.NutritionIXQuery
     */
    public NutritionIXQuery addArgument(String arg)
    {
        args+=arg.replace(" ", "%20");
        return this;
    }

    /**
     * Reset all arguments to default.
     * @return net.johnbrooks.NW.NutritionIXQuery
     */
    public NutritionIXQuery clearArguments()
    {
        args = "";
        return this;
    }


    /**
     * Sets the type of query that will be run. Doing so resets the query to default initialization.
     * @param type
     * @return net.johnbrooks.NW.NutritionIXQuery
     */
    public NutritionIXQuery setType(NutritionIXQueryType type)
    {
        this.type = type;
        this.query = "https://nutritionix-api.p.mashape.com/v1_1/" + ((type == NutritionIXQueryType.GET) ? "item?id=" : "search/");
        this.args = "";
        this.fields = "?fields=";
        return this;
    }

    public HttpResponse<JsonNode> runQuery()
    {
        try
        {
            HttpResponse<JsonNode> response = Unirest.get(toString())
                    .header("X-Mashape-Key", "1T5HvJ99YUmsh0xoWLFk0mbwftMvp1nvlRLjsnWXTSwRlg3oFl")
                    .header("Accept", "application/json")
                    .asJson();
            return response;
        } catch (UnirestException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString()
    {
        return query + args + (type == NutritionIXQueryType.SEARCH ? fields : "");
    }

    enum NutritionIXQueryType
    {
        GET, SEARCH
    }
}
