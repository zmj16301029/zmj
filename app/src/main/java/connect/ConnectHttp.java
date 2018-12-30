package connect;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 16301029 on 2018/11/3.
 */

public class ConnectHttp
{
    private String method;
    private HttpURLConnection connection;

    public ConnectHttp(String method)
    {
        this.method = method;
    }

    public void connect()
    {
        try
        {
            URL url = new URL("http://10.0.2.2:8806/sport/MySer");
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            connection.setRequestMethod(method);
            connection.setDoOutput(true);
            connection.setDoInput(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }

    public HttpURLConnection getConnection()
    {
        return connection;
    }
}
