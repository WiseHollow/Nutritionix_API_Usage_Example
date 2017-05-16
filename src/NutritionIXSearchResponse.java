import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

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
}

