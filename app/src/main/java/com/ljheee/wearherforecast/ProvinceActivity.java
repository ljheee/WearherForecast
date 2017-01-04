package com.ljheee.wearherforecast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import adapter.ProvinceAdapter;


public class ProvinceActivity extends Activity {
    /**
     * UI控件
     */
    ListView listView_province;
    /**
     * listView视图适配器
     */
    ProvinceAdapter provinceAdapter;
    /**
     * 数据
     */
    String[] data;

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province);
        context = getApplicationContext();
        initView();

    }
    private void initView(){
        listView_province = (ListView) findViewById(R.id.listView_province);

        data = new String[]{"北京","上海","天津","重庆","安徽","福建","甘肃","广东","广西","贵州",
                "海南","河北","河南","黑龙江","湖北","湖南","吉林","江苏","江西","辽宁","内蒙古","宁夏",
                "青海","山东","山西","陕西","四川","西藏","新疆","云南","浙江","香港","澳门","台湾",
                "其它"};

        provinceAdapter = new ProvinceAdapter(this,data);
        listView_province.setAdapter(provinceAdapter);

        //设置点击事件
        listView_province.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context,CityActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("position",position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
