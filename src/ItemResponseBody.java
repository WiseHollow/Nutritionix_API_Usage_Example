import com.mashape.unirest.http.JsonNode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by John on 5/16/2017.
 */
class ItemResponseBody
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
