package net;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import bean.WeatherInfo;

public class GetWeatherInfo {

    static boolean isNetData ;
    public static WeatherInfo getWeatherInfo(String city,Context context) {
        WeatherInfo weatherInfo = null;
        InputStream in;
        StringBuffer buffer = null;
        try {
            buffer = GetWeatherString.getRequest(UrlConfig.getHttpUrl(city), context,city);
//            Log.d("city",buffer.toString());
            //判断是否从网络取到数据
            if (buffer.toString().length() != 0) {
                in = new ByteArrayInputStream(buffer.toString().getBytes());
                Reader reader = new InputStreamReader(in, "utf-8");
                weatherInfo = new Gson().fromJson(reader, WeatherInfo.class);
                in.close();
                isNetData =true;

            } else {
                //如果没取到，则从之前存的历史数据中读取天气信息
               if(context!=null){
                   in = context.openFileInput("weather"+city);
                   Log.d("gaga", "weather"+city);
                   //int size = in.available();
                   Reader reader = new InputStreamReader(in, "utf-8");
                   weatherInfo = new Gson().fromJson(reader, WeatherInfo.class);
                   isNetData = false;
                   reader.close();
               }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherInfo;
    }

    public static boolean DataFromNet(){
//        Log.d("is",String.valueOf(isNetData));
        return isNetData;
    }
}
