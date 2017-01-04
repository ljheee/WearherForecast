package com.ljheee.wearherforecast;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import fragment.WeatherFragment;
import util.ImageUtil;

public class MainActivity extends ActionBarActivity implements WeatherFragment.WeatherCallback {

    @Bind(R.id.FrameLayout_main)
    FrameLayout frameLayout;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    android.support.v7.app.ActionBar actionBar;

    @Bind(R.id.right_drawer)
    ListView rightDrawerListView;

    static ArrayList<String>  historyCity ;
    ArrayAdapter historyCityAdapter;

    FragmentTransaction ft;

    WeatherFragment wfragmen;
    volatile String cityName= "长沙";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);
        frameLayout = (FrameLayout) findViewById(R.id.FrameLayout_main);
        actionBar = getSupportActionBar();//null

        historyCity = new ArrayList<>();
        historyCityAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_activated_1  ,historyCity);
        rightDrawerListView = (ListView) findViewById(R.id.right_drawer);
        rightDrawerListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        rightDrawerListView.setAdapter(historyCityAdapter);
        historyCity.add(0,"历史数据");

        rightDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 关闭抽屉
//                drawerLayout.closeDrawer(GravityCompat.START);

                ft = MainActivity.this.getFragmentManager().beginTransaction();
                wfragmen = new WeatherFragment();
                Bundle cn = new Bundle();
                cn.putString("curCity",historyCity.get(position+1));
                wfragmen.setArguments(cn);
                ft.add(R.id.content_root,wfragmen).commit();//替换
                actionBar.setTitle(cityName);//显示城市名
            }
        });

    }

    /**
     * MainActivity每次回到前台进程，就会调用该方法
     */
    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        Bundle bun = intent.getExtras();
        if(bun != null){
            cityName =  bun.getString("selected_city");
            historyCity.add(cityName);
        }
        historyCityAdapter.notifyDataSetChanged();

        ft = getFragmentManager().beginTransaction();
        wfragmen = new WeatherFragment();
        Bundle cn = new Bundle();
        cn.putString("curCity",cityName);
        wfragmen.setArguments(cn);
        ft.add(R.id.content_root,wfragmen).commit();//替换
        actionBar.setTitle(cityName);//显示城市名
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.more_action:
                startActivity(new Intent(this,ProvinceActivity.class));
                break;
            case R.id.setting_action:

                break;
            case R.id.exit_action:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    //从回掉接口获得城市名
    @Override
    public void Send_CityName(String city_name, String cond) {
        actionBar.setTitle(city_name);
        city_name = city_name;
        //改变背景图片
        frameLayout.setBackgroundResource(ImageUtil.Change_Bg_ImageId(cond));
    }
}
