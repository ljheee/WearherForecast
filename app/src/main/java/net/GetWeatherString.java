package net;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class GetWeatherString {
    public static StringBuffer getRequest(String httpUrl, Context context,String city_name) {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader reader;
        InputStream in = null;
        try {
            URL url = new URL(httpUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            //设置连接超时 毫秒
            connection.setConnectTimeout(5000);
            //读取超时
            connection.setReadTimeout(5000);
            int code = connection.getResponseCode();
//            Log.d("StringText", code + "hah");
            //响应成功
            if (code == HttpsURLConnection.HTTP_OK) {
                in = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                char buf[] = new char[1024 * 4];
                int size;
                while ((size = reader.read(buf)) != -1) {
                    stringBuffer.append(buf, 0, size);
                }
                String text = stringBuffer.toString();

                //将数据以覆盖的方式写入到内部存储，在没有网络的情况下读取上次的天气信息
                if(context!=null){
                    OutputStream out = context.openFileOutput("weather"+city_name, Context.MODE_PRIVATE);//Todo私有文件太多，历史数据插入数据库
                    Writer writer = new OutputStreamWriter(out, "utf-8");
                    writer.write(text);
                    writer.close();
                    reader.close();
                }

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
//            Log.d("StringText", "响应超时" + "hah");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer;
    }
}
