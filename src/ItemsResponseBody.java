import com.mashape.unirest.http.JsonNode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by John on 5/16/2017.
 */
class ItemsResponseBody
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

                int calories = fields.getInt("nf_calories");

                items[i] = new NutritionIXItem(id, name, brand, calories);
            }
        } catch (JSONException e)
        {
            e.printStackTrace();
            return;
        }


    }

    public NutritionIXItem[] getItems() { return items; }
}
