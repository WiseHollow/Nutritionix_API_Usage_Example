import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

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
}

