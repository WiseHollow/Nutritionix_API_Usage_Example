import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by John on 5/16/2017.
 */
public class NutritionIXGetItemResponse
{
    private ResponseHeaders headers;
    private ItemResponseBody body;

    public NutritionIXGetItemResponse(HttpResponse<JsonNode> response)
    {
        body = new ItemResponseBody(response.getBody());
        headers = new ResponseHeaders(response.getHeaders());
    }

    public ItemResponseBody getBodyDetails() { return body; }
    public ResponseHeaders getHeaderDetails() { return headers; }

    /**
     * Created by John on 5/16/2017.
     */
    static class ItemResponseBody
    {
        private NutritionIXItem item;

        public ItemResponseBody(JsonNode body)
        {
            try
            {
                JSONObject jsonItem = body.getObject();
                if (jsonItem == null)
                    return;

                String id = jsonItem.getString("item_id");
                String name = jsonItem.getString("item_name");
                String brand = jsonItem.getString("brand_name");

                String servingSize = jsonItem.getString("nf_serving_size_unit");

                int calories = jsonItem.getInt("nf_calories");

                item = new NutritionIXItem(id, name, brand, calories, servingSize);
            } catch (JSONException e)
            {
                e.printStackTrace();
                return;
            }
        }

        public NutritionIXItem getItem() { return item; }
    }
}

