package net.johnbrooks.NW;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by John on 5/16/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        //net.johnbrooks.NW.NutritionIXQuery query = new net.johnbrooks.NW.NutritionIXQuery(net.johnbrooks.NW.NutritionIXQuery.NutritionIXQueryType.GET);
        //query.addArgument("51c3d78797c3e6d8d3b546cf");
        //HttpResponse<JsonNode> node = query.runQuery();
        //net.johnbrooks.NW.NutritionIXGetItemResponse response = new net.johnbrooks.NW.NutritionIXGetItemResponse(node);
//
        //System.out.println(response.getBodyDetails().getItem());
//
        //query = new net.johnbrooks.NW.NutritionIXQuery(net.johnbrooks.NW.NutritionIXQuery.NutritionIXQueryType.SEARCH);
        //query.addArgument("cheddar cheese")
        //        .addField(net.johnbrooks.NW.NutritionIXField.ITEM_NAME)
        //        .addField(net.johnbrooks.NW.NutritionIXField.ITEM_ID)
        //        .addField(net.johnbrooks.NW.NutritionIXField.ITEM_BRAND)
        //        .addField(net.johnbrooks.NW.NutritionIXField.SERVING_SIZE)
        //        .addField(net.johnbrooks.NW.NutritionIXField.CALORIES)
        //        .addField(net.johnbrooks.NW.NutritionIXField.TOTAL_FAT);
        //node = query.runQuery();
//
        //net.johnbrooks.NW.NutritionIXSearchResponse searchResponse = new net.johnbrooks.NW.NutritionIXSearchResponse(node);
        //for (net.johnbrooks.NW.NutritionIXItem item : searchResponse.getBodyDetails().getItems())
        //    System.out.println(item);

        String searchFor;

        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("What food do you want to search for? ");
            searchFor = br.readLine();
            System.out.println("Searching for " + searchFor + "...");
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        NutritionIXItem[] items = NutritionIXQuery.searchForItems(searchFor);
        for (NutritionIXItem item : items)
            System.out.println(item);
    }
}