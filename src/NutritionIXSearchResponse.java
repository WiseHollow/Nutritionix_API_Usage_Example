import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by John on 5/16/2017.
 */
public class NutritionIXSearchResponse
{
    private ResponseHeaders headers;
    private ItemsResponseBody body;

    public NutritionIXSearchResponse(HttpResponse<JsonNode> response)
    {
        body = new ItemsResponseBody(response.getBody());
        headers = new ResponseHeaders(response.getHeaders());
    }

    public ItemsResponseBody getBodyDetails() { return body; }
    public ResponseHeaders getHeaderDetails() { return headers; }

    /**
     * Created by John on 5/16/2017.
     */
    static class ItemsResponseBody
    {
        private NutritionIXItem[] items;

        public ItemsResponseBody(JsonNode body)
        {
            try
            {
                JSONArray hits = body.getObject().getJSONArray("hits");
                if (hits.length() == 0)
                {
                    System.out.println("Search returned no items.");
                    return;
                }
                items = new NutritionIXItem[hits.length()];
                for (int i = 0; i < hits.length(); i++)
                {
                    JSONObject jsonItem = hits.getJSONObject(i);
                    if (jsonItem == null)
                        continue;
                    JSONObject fields = jsonItem.getJSONObject("fields");

                    String id = fields.getString("item_id");
                    String name = fields.getString("item_name");
                    String brand = fields.getString("brand_name");

                    String servingSize = fields.getString("nf_serving_size_unit");

                    int calories = fields.getInt("nf_calories");

                    items[i] = new NutritionIXItem(id, name, brand, calories, servingSize);
                }
            } catch (JSONException e)
            {
                e.printStackTrace();
                return;
            }


        }

        public NutritionIXItem[] getItems() { return items; }
    }
}

