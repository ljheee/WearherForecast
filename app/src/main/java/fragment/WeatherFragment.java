package fragment;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ljheee.wearherforecast.R;

import net.GetWeatherInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import adapter.DailyAdapter;
import adapter.HourAdapter;
import bean.AirQuality;
import bean.BasicInfo;
import bean.Daily_forecast;
import bean.Hourly_forecast;
import bean.Now;
import bean.Suggestion;
import bean.WeatherInfo;
import butterknife.Bind;
import butterknife.ButterKnife;
import util.DateUtil;
import util.ImageUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {

    @Bind(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    @Bind(R.id.tv_now_temp)
    TextView textView_now_temp;

    @Bind(R.id.tv_now_week)
    TextView textView_now_week;

    @Bind(R.id.tv_now_cond)
    TextView textView_now_cond;

    @Bind(R.id.tv_air_quality)
    TextView textView_air_quality;

    @Bind(R.id.tv_air_index)
    TextView textView_air_index;

    @Bind(R.id.tv_air_qlty)
    TextView textView_air_qlty;

    @Bind(R.id.tv_pm10)
    TextView textView_air_pm10;

    @Bind(R.id.tv_pm2_5)
    TextView textView_air_pm25;

    @Bind(R.id.tv_NO2)
    TextView textView_air_NO2;

    @Bind(R.id.tv_SO2)
    TextView textView_air_SO2;

    @Bind(R.id.tv_O3)
    TextView textView_air_O3;

    @Bind(R.id.tv_CO)
    TextView textView_air_CO;

    @Bind(R.id.tv_comf)
    TextView textView_comfortable;

    @Bind(R.id.tv_clean_car)
    TextView textView_clean_car;

    @Bind(R.id.tv_wear_clothes)
    TextView textView_wear_clothes;

    @Bind(R.id.tv_flue)
    TextView textView_flue;

    @Bind(R.id.tv_sport)
    TextView textView_sport;

    @Bind(R.id.tv_travel)
    TextView textView_travel;

    @Bind(R.id.tv_uv)
    TextView textView_uv;

    @Bind(R.id.tv_wind_drec)
    TextView textView_wind_desc;

    @Bind(R.id.tv_wind_speed)
    TextView textView_wind_speed;

    @Bind(R.id.tv_sun_rise)
    TextView textView_sun_rise;

    @Bind(R.id.tv_sun_set)
    TextView textView_sun_set;

    @Bind(R.id.tv_air_hum)
    TextView textView_air_hum;

    @Bind(R.id.tv_rain_count)
    TextView textView_rain_count;

    @Bind(R.id.tv_feel_temp)
    TextView textView_feel_temp;

    @Bind(R.id.tv_air_pres)
    TextView textView_air_pres;

    @Bind(R.id.nothing)
    TextView text_noting_show;
    //当前天气
    Now now;
    //基本信息
    BasicInfo basicInfo;
    //空气质量
    AirQuality airQuality;
    //
    List<Daily_forecast> daily_forecasts_data = null;
    //
    List<Hourly_forecast> hourly_forecasts_data;
    //生活指数
    Suggestion suggestion;
    //风向风速
    @Bind(R.id.image_now_cond)
    ImageView imageView;


//    /**
//     * 未来几天天气预报横向布局
//     */
//    @Bind(R.id.horizontal_ListView_daily)
//    HorizontalListView horizontalListView_daily;
//    /**
//     * 未来几小时天气预报横向横向布局
//     */
//    @Bind(R.id.horizontal_ListView_hour)
//    HorizontalListView horizontalListView_hour;
    @Bind(R.id.recyclerView_daily)
    RecyclerView recyclerView_daily;
    @Bind(R.id.recyclerView_hourly)
    RecyclerView recyclerView_hourly;

    //上下文
    Context context;
    //所有天气信息
    WeatherInfo weatherInfo;

    //每天天气适配器
    DailyAdapter dailyAdapter;
    //
    HourAdapter hourAdapter;

    //上次更新时间
    String dateString;

    //回掉接口
    WeatherCallback weatherCallback;


    private static final String EXTRA_DATA = "CITY";
    private String city_name;

    public WeatherFragment(){
    }


    /**
     * 获得实例
     * @param
     * @return
     */
    public static WeatherFragment getInstance(String  city_name){
        WeatherFragment weatherFragment = new WeatherFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_DATA,city_name);
        weatherFragment.setArguments(bundle);
        return weatherFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        city_name = getArguments().getString("curCity");
        //
//        city_name = (String) getArguments().getSerializable(EXTRA_DATA);
    }

//    @Override
//    public void onAttach(Context context) {//API23  6.0不执行
//        super.onAttach(context);
//        this.context = getActivity();
//        //给callback赋值
//        if (context instanceof WeatherCallback) {
//            weatherCallback = (WeatherCallback) context;
//        }
//    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity;
        if (context instanceof WeatherCallback) {
            weatherCallback = (WeatherCallback) context;
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_weather, container, false);
        ButterKnife.bind(this, v);
        initRefreshLayout();
        new getInfoTask().execute();
//        imageView.setImageResource(R.drawable.fengche);
        //天气状况
        return v;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //释放callback
        weatherCallback = null;
    }

    /**
     * weather的回调接口，用来向主活动传递城市名和天气状况，用来改变天气背景
     */
    public interface WeatherCallback {
        public void Send_CityName(String city_name, String cond);
    }

    public void initWeatherInfo() {
        if (weatherInfo != null) {
            //得到当前天气
            now = weatherInfo.getAllInfos().get(0).getNow();
            //设置天气背景图片
//            refreshLayout.setBackgroundResource(ImageUtil.Change_Bg_ImageId(now.getCond().getCond_day()));
//            MediaPlayer mp = MediaPlayer.create(context, R.raw.video_cold);
//            mp.start();
            imageView.setImageResource(ImageUtil.Change_Cond_ImageId(now.getCond().getCond_day()));
            basicInfo = weatherInfo.getAllInfos().get(0).getBasic();

            airQuality = weatherInfo.getAllInfos().get(0).getAqi();
            //得到未来几天的天气
            daily_forecasts_data = weatherInfo.getAllInfos().get(0).getDaily_forecasts();
            //得到未来几小时的天气
            hourly_forecasts_data = weatherInfo.getAllInfos().get(0).getHourly_forecasts();
            //现在温度
            textView_now_temp.setText(now.getTmp() + "°");
            //当前星期几
            String local_time = basicInfo.getUpdate().getLoc();
//            Log.d("hello", local_time + "g");
            textView_now_week.setText(DateUtil.getWeek(local_time.substring(0, local_time.indexOf(" "))) + " "
                    + local_time.substring(local_time.indexOf(" ")) + "发布");
            //天气状况
            textView_now_cond.setText(now.getCond().getCond_day() + " ");
            //空气质量/
            if (airQuality != null)
                textView_air_quality.setText(" 空气:" + airQuality.getCityAir().getQlty());
            else
                textView_air_quality.setText("暂无数据");
            initSun();
            //将当天从未来天气几天天气预报移除
            daily_forecasts_data.remove(0);
            //装载适配器
            dailyAdapter = new DailyAdapter(daily_forecasts_data,context);
            recyclerView_daily.setLayoutManager(new GridLayoutManager(
                    context,
                    4,
                    GridLayout.VERTICAL,
                    false
            ));
            recyclerView_daily.setAdapter(dailyAdapter);
            //
            if (hourly_forecasts_data.size() > 0) {
                text_noting_show.setVisibility(View.INVISIBLE);
                //

//            horizontalListView.setOnScrollListener(new AbsListView.OnScrollListener() {
//                @Override
//                public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//                }
//
//                @Override
//                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                    boolean enable = false;
//                    if (listView != null && listView.getChildCount() > 0) {
//                        // 判断listView子元素是否为空
//                        boolean firstItemVisible = listView.getFirstVisiblePosition() == 0;
//                        //判断是否到达顶部
//                        boolean topOfFirstItemVisible = listView.getChildAt(0).getTop() == 0;
//                        // enabling or disabling the refresh layout
//                        enable = firstItemVisible && topOfFirstItemVisible;
//                    }
//                    refreshLayout.setEnabled(enable);
//                }
//            });
                //s
                initAirQuality();
                hourAdapter = new HourAdapter(context, hourly_forecasts_data, now.getCond().getCond_day(), now);
                recyclerView_hourly.setLayoutManager(new GridLayoutManager(
                        context,
                        3,
                        GridLayout.VERTICAL,
                        false
                ));
                recyclerView_hourly.setAdapter(hourAdapter);
            } else {
                //未来几小时天气如果不存在则显示
                text_noting_show.setVisibility(View.VISIBLE);
            }
            initLifeIndex();
            initNow();
        }
    }

    public void initAirQuality() {
        if (weatherInfo != null) {
            airQuality = weatherInfo.getAllInfos().get(0).getAqi();
            AirQuality.CityAir cityAir = null;
            if(airQuality!=null)
                cityAir = airQuality.getCityAir();
            if (cityAir != null) {
                textView_air_index.setText(cityAir.getAqi());
                textView_air_qlty.setText(cityAir.getQlty());
                textView_air_pm10.setText(cityAir.getPm10());
                textView_air_pm25.setText(cityAir.getPm25());
                textView_air_NO2.setText(cityAir.getNo2());
                textView_air_SO2.setText(cityAir.getSo2());
                textView_air_O3.setText(cityAir.getO3());
                textView_air_CO.setText(cityAir.getCo());
            } else {
                textView_air_index.setText("暂无数据");
                textView_air_qlty.setText("暂无数据");
                textView_air_pm10.setText("暂无数据");
                textView_air_pm25.setText("暂无数据");
                textView_air_NO2.setText("暂无数据");
                textView_air_SO2.setText("暂无数据");
                textView_air_O3.setText("暂无数据");
                textView_air_CO.setText("暂无数据");
            }
        }
    }

    public void initLifeIndex() {
        if (weatherInfo != null) {
            suggestion = weatherInfo.getAllInfos().get(0).getSuggestion();
            textView_comfortable.setText(suggestion.getComf().getBrf() + ":" + suggestion.getComf().getTxt());
            textView_clean_car.setText(suggestion.getCw().getBrf() + ":" + suggestion.getCw().getTxt());
            textView_wear_clothes.setText(suggestion.getDrsg().getBrf() + ":" + suggestion.getDrsg().getTxt());
            textView_flue.setText(suggestion.getFlu().getBrf() + ":" + suggestion.getFlu().getTxt());
            textView_sport.setText(suggestion.getSport().getBrf() + ":" + suggestion.getSport().getTxt());
            textView_travel.setText(suggestion.getTrav().getBrf() + ":" + suggestion.getTrav().getTxt());
            textView_uv.setText(suggestion.getUv().getBrf());
        }
    }

    public void initNow() {
        if (weatherInfo != null) {
            textView_wind_desc.setText(now.getWind().getDir());
            textView_wind_speed.setText(now.getWind().getSc() + "级");
            textView_air_hum.setText(now.getHum() + "%");
            textView_feel_temp.setText(now.getFl() + "℃");
            textView_rain_count.setText(now.getPcpn() + "mm");
            String press = now.getPres();
            textView_air_pres.setText(press.substring(0, press.length() - 1) + "." + press.substring(press.length() - 1) + "KPa");
        }
    }

    public void initSun() {
        if (weatherInfo != null) {
            textView_sun_rise.setText(daily_forecasts_data.get(0).getAstro().getSunrise());
            textView_sun_set.setText(daily_forecasts_data.get(0).getAstro().getSunset());
        }
    }


    private void initRefreshLayout() {
        //设置刷新圈的颜色
        refreshLayout.setColorSchemeColors(Color.WHITE);
        //设置背景色
        refreshLayout.setProgressBackgroundColorSchemeColor(Color.TRANSPARENT);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread() {
                    @Override
                    public void run() {
                        //子线程不能直接访问UI
                        new getInfoTask().execute();
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                initWeatherInfo();
                                refreshLayout.setRefreshing(false);
                            }
                        });
                    }
                }.start();
            }
        });
    }

    //是否从网络获取数据
    boolean isNetData;

    private class getInfoTask extends AsyncTask<Void, Boolean, WeatherInfo> {

        @Override
        protected WeatherInfo doInBackground(Void... params) {
            weatherInfo = GetWeatherInfo.getWeatherInfo(city_name, context);
            isNetData = GetWeatherInfo.DataFromNet();
            return weatherInfo;
        }

        @Override
        protected void onPostExecute(WeatherInfo weatherInfo) {
            super.onPostExecute(weatherInfo);
            if (isNetData && weatherInfo != null) {
                long time = System.currentTimeMillis();
                Date date = new Date(time);
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm");
                dateString = simpleDateFormat1.format(date);
                initWeatherInfo();
                weatherCallback.Send_CityName(basicInfo.getCity(), now.getCond().getCond_day());
                //Toast.makeText(getActivity(), "刷新成功", Toast.LENGTH_SHORT).show();
            } else if (!isNetData) {
                initWeatherInfo();
                Toast.makeText(getActivity(), "请检查网络", Toast.LENGTH_SHORT).show();
            }
        }

    }

}
