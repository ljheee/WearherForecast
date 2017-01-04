package net;

public class UrlConfig {
    static String API_KRY="&key=1867007d77b64af494409156f6b1a15b";
    static String url = "https://api.heweather.com/x3/weather?city=";

    public static String getHttpUrl(String city){
        return url+city+API_KRY;
    }
}
