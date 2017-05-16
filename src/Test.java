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
        try
        {
            // get info using id of food

            //HttpResponse<JsonNode> response = Unirest.get("https://nutritionix-api.p.mashape.com/v1_1/item?upc=49000036756")
            //        .header("X-Mashape-Key", "1T5HvJ99YUmsh0xoWLFk0mbwftMvp1nvlRLjsnWXTSwRlg3oFl")
            //        .header("Accept", "application/json")
            //        .asJson();
//
            //System.out.println("Reponse Code: " + response.getCode() + (response.getCode() == 200 ? "/okay" : "/error"));
            //System.out.println("Reponse: " + response.getBody());
//
            //JSONObject jsonObject = response.getBody().getObject();
            //String calories = jsonObject.get("nf_calories").toString();
            //System.out.println("Calories in " + jsonObject.get("item_name").toString() + ": " + calories);

            //Search test and display value

            String fields = "item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat"; // what info should we pull?
            HttpResponse<JsonNode> searchResponse = Unirest.get("https://nutritionix-api.p.mashape.com/v1_1/search/cheddar%20cheese?fields=" + fields)
                    .header("X-Mashape-Key", "1T5HvJ99YUmsh0xoWLFk0mbwftMvp1nvlRLjsnWXTSwRlg3oFl")
                    .header("Accept", "application/json")
                    .asJson();

            NutritionIXSearchResponse search = new NutritionIXSearchResponse(searchResponse);
            //for(NutritionIXItem item : search.getBodyDetails().getItems())
            //    System.out.println(item);
        }
        catch (UnirestException e)
        {
            e.printStackTrace();
        }
    }
}