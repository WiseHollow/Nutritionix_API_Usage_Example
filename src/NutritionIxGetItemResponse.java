import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by John on 5/16/2017.
 */
public class NutritionIxGetItemResponse
{
    private ResponseHeaders headers;
    private ItemResponseBody body;

    public NutritionIxGetItemResponse(HttpResponse<JsonNode> response)
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
                JSONObject fields = jsonItem.getJSONObject("fields");

                String id = fields.getString("item_id");
                String name = fields.getString("item_name");
                String brand = fields.getString("brand_name");

                int calories = fields.getInt("nf_calories");

                item = new NutritionIXItem(id, name, brand, calories);
            } catch (JSONException e)
            {
                e.printStackTrace();
                return;
            }
        }

        public NutritionIXItem getItem() { return item; }
    }
}

