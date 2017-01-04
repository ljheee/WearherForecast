package util;


import com.ljheee.wearherforecast.R;

/**
 * 根据天气，更换UI背景
 */
public class ImageUtil {

    public static int Change_Bg_ImageId(String cond) {
        int id = 0;
        switch (cond) {
            case "晴":
                id = R.drawable.dualclock_widget_bg_sunny_day;
                break;
            case "多云":
            case "阴":
            case "晴间多云":
            case "少云":
                id = R.drawable.dualclock_widget_bg_cloudy_day;
                break;
            case "冷":
                id = R.drawable.dualclock_widget_bg_cloudy_day;
                break;
            case "雾":
            case "薄雾":
                id = R.drawable.dualclock_widget_bg_fog_day;
                break;
            case "有风":
            case "和风":
            case "狂爆风":
            case "清风":
            case "强风/劲风":
            case "疾风":
            case "大风":
            case "风暴":
            case "龙卷风":
            case "飓风":
            case "平静":
            case "微风":
            case "热带风暴":
            case "烈风":
                id = R.drawable.dualclock_widget_bg_wind_day;
                break;
            case "雨":
            case "阵雨":
            case "小雨":
            case "中雨":
            case "冻雨":
            case "大雨":
            case "极端降雨":
            case "暴雨":
            case "特大暴雨":
            case "大暴雨":
            case "强阵雨":
                id = R.drawable.dualclock_widget_bg_rain_day;
                break;
            case "强雷阵雨":
            case "雷阵雨伴有冰雹":
                id = R.drawable.dualclock_widget_bg_thunderstorm_day;
                break;
            case "毛毛雨/细雨":
                id = R.drawable.dualclock_widget_bg_shower_day;
                break;
            case "雪":
            case "小雪":
            case "中雪":
            case "大雪":
            case "暴雪":
            case "雨夹雪":
            case "雨雪天气":
            case "阵雨夹雪":
            case "阵雪":
                id = R.drawable.dualclock_widget_bg_snow_day;
                break;
            case "沙尘暴":
                id = R.drawable.dualclock_widget_bg_sand_devil_day;
                break;
            case "雷阵雨":
                id = R.drawable.dualclock_widget_bg_thunderstorm_day;
                break;
            case "热":
                id = R.drawable.dualclock_widget_bg_hot_day;
                break;
            case "霾":
            case "浮尘":
                id = R.drawable.dualclock_widget_bg_haze_day;
                break;
        }
        return id;
    }

    public static int Change_Cond_ImageId(String cond) {
        int id = 0;
        switch (cond) {
            case "晴":
                id = R.drawable.dualclock_widget_icon_sunny_day;
                break;
            case "多云":
            case "阴":
            case "晴间多云":
            case "少云":
                id = R.drawable.dualclock_widget_icon_cloud_day;
                break;
            case "冷":
                id = R.drawable.dualclock_widget_icon_cold_day;
                break;
            case "雾":
                id = R.drawable.dualclock_widget_icon_fog_day;
                break;
            case "阵雨":
                id = R.drawable.dualclock_widget_icon_moderate_rain_day;
                break;
            case "雨":
            case "小雨":
            case "中雨":
            case "冻雨":
                id = R.drawable.dualclock_widget_icon_rain_day;
                break;
            case "毛毛雨/细雨":
                id = R.drawable.dualclock_widget_icon_shower_day;
                break;
            case "极端降雨":
                id = R.drawable.dualclock_widget_icon_severe_storm_day;
                break;
            case "暴雨":
            case "大雨":
                id = R.drawable.dualclock_widget_icon_storm_day;
                break;
            case "特大暴雨":
            case "大暴雨":
                id = R.drawable.dualclock_widget_icon_severe_storm_day;
                break;
            case "强阵雨":
                id = R.drawable.dualclock_widget_icon_moderate_rain_day;
                break;
            case "强雷阵雨":
            case "雷阵雨":
            case "雷阵雨伴有冰雹":
                id = R.drawable.dualclock_widget_icon_thunderstorm_day;
                break;
            case "小雪":
            case "中雪":
                id = R.drawable.dualclock_widget_icon_snow_day;
                break;
            case "大雪":
                id = R.drawable.dualclock_widget_icon_heavy_snow_day;
                break;
            case "暴雪":
                id = R.drawable.dualclock_widget_icon_snowstorm_day;
                break;
            case "雨夹雪":
            case "雨雪天气":
                id = R.drawable.dualclock_widget_icon_light_snow_day;
                break;
            case "阵雨夹雪":
            case "阵雪":
                id = R.drawable.dualclock_widget_icon_moderate_snow_day;
                break;
            case "有风":
            case "和风":
            case "狂爆风":
            case "清风":
            case "强风/劲风":
            case "疾风":
            case "大风":
            case "风暴":
            case "龙卷风":
            case "飓风":
            case "平静":
            case "微风":
            case "热带风暴":
            case "烈风":
                id = R.drawable.dualclock_widget_icon_wind_day;
                break;
            case "扬沙":
            case "火山灰":
            case "沙尘暴":
            case "强沙尘暴":
                id = R.drawable.dualclock_widget_icon_sand_devil_day;
                break;
            case "热":
                id = R.drawable.dualclock_widget_icon_hot_day;
                break;
            case "霾":
            case "浮尘":
                id = R.drawable.dualclock_widget_icon_haze_day;
                break;

        }
        return id;
    }
}
