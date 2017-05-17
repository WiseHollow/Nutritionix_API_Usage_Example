import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by John on 5/16/2017.
 */
public class Test
{
    public static void main(String[] args)
    {
        //try
        //{
        //    // get info using id of food
//
        //    //HttpResponse<JsonNode> response = Unirest.get("https://nutritionix-api.p.mashape.com/v1_1/item?upc=49000036756")
        //    //        .header("X-Mashape-Key", "1T5HvJ99YUmsh0xoWLFk0mbwftMvp1nvlRLjsnWXTSwRlg3oFl")
        //    //        .header("Accept", "application/json")
        //    //        .asJson();
////
        //    //NutritionIxGetItemResponse getResponse = new NutritionIxGetItemResponse(response);
        //    //System.out.println("Name: " + getResponse.getBodyDetails().getItem().getName());
//
        //    //Search test and display value
//
        //    String fields = "item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat%2Cnf_serving_size_unit"; // what info should we pull?
        //    HttpResponse<JsonNode> searchResponse = Unirest.get("https://nutritionix-api.p.mashape.com/v1_1/search/cheddar%20cheese?fields=" + fields)
        //            .header("X-Mashape-Key", "1T5HvJ99YUmsh0xoWLFk0mbwftMvp1nvlRLjsnWXTSwRlg3oFl")
        //            .header("Accept", "application/json")
        //            .asJson();
//
        //    NutritionIXSearchResponse search = new NutritionIXSearchResponse(searchResponse);
        //    for(NutritionIXItem item : search.getBodyDetails().getItems())
        //        System.out.println(item);
//
        //
        //}
        //catch (UnirestException e)
        //{
        //    e.printStackTrace();
        //}

        NutritionIXQuery query = new NutritionIXQuery(NutritionIXQuery.NutritionIXQueryType.GET);
        query.addArgument("49000036756");
        HttpResponse<JsonNode> node = query.runQuery();
        NutritionIxGetItemResponse response = new NutritionIxGetItemResponse(node);
        System.out.println(response.getBodyDetails().getItem());

        query = new NutritionIXQuery(NutritionIXQuery.NutritionIXQueryType.SEARCH);
        query.addArgument("cheddar cheese")
                .addField("item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat%2Cnf_serving_size_unit");
        node = query.runQuery();
        NutritionIXSearchResponse searchResponse = new NutritionIXSearchResponse(node);
        for (NutritionIXItem item : searchResponse.getBodyDetails().getItems())
            System.out.println(item);
    }
}