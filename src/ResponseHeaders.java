import java.util.Map;

/**
 * Created by John on 5/16/2017.
 */
public class ResponseHeaders
{
    private String date;
    private String status;
    private String connection;
    private String server;

    public ResponseHeaders(Map<String, String> headers)
    {
        date = headers.get("date");
        status = headers.get("status");
        connection = headers.get("connection");
        server = headers.get("server");

        System.out.println("Received: " + status);
        //for (String key : headers.keySet())
        //    System.out.println(key + " | " + headers.get(key).toString());
    }

    public String getDate() { return date; }
    public String getStatus() { return status; }
    public String getConnection() { return connection; }
    public String getServer() { return server; }
}
