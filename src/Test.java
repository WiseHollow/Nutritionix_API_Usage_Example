import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

/**
 * Created by John on 5/16/2017.
 */
public class Test
{
    public static void main(String[] args)
    {
        NutritionIXQuery query = new NutritionIXQuery(NutritionIXQuery.NutritionIXQueryType.GET);
        query.addArgument("51c3d78797c3e6d8d3b546cf");
        HttpResponse<JsonNode> node = query.runQuery();
        NutritionIXGetItemResponse response = new NutritionIXGetItemResponse(node);

        System.out.println(response.getBodyDetails().getItem());

        query = new NutritionIXQuery(NutritionIXQuery.NutritionIXQueryType.SEARCH);
        query.addArgument("cheddar cheese")
                .addField(NutritionIXField.ITEM_NAME)
                .addField(NutritionIXField.ITEM_ID)
                .addField(NutritionIXField.ITEM_BRAND)
                .addField(NutritionIXField.SERVING_SIZE)
                .addField(NutritionIXField.CALORIES)
                .addField(NutritionIXField.TOTAL_FAT);
        node = query.runQuery();

        NutritionIXSearchResponse searchResponse = new NutritionIXSearchResponse(node);
        for (NutritionIXItem item : searchResponse.getBodyDetails().getItems())
            System.out.println(item);
    }
}