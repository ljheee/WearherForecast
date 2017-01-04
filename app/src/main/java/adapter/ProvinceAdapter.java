package adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ljheee.wearherforecast.R;

/**
 * Created by lenovo on 2017/1/2.
 */
public class ProvinceAdapter extends BaseAdapter {
    /**
     * 下上文
     */
    Context context;
    /**
     * 省份数据
     */
    String[] province;

    /**
     * 加载解析布局模板
     */
    LayoutInflater layoutInflater;

    public ProvinceAdapter(Context context,String[] province){
        this.context = context;
        this.province = province;
        //获得服务实例
        layoutInflater = layoutInflater.from(context);
    }

    /**
     * 数据总数
     * @return
     */
    @Override
    public int getCount() {
        return province.length;
    }

    /**
     * 获得特定位置的数据
     * @param position 位置
     * @return
     */
    @Override
    public Object getItem(int position) {
        return province[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            //根据布局模板创建视图
            convertView = layoutInflater.inflate(R.layout.item_province,null);
            //每个视图项需要一个viewHolder
            viewHolder = new ViewHolder(convertView);
            //视图项关联了它的视图结构
            convertView.setTag(viewHolder);
        }else{
            //有复用的视图项，不创建，并直接获得结构
            viewHolder = (ViewHolder)convertView.getTag();
        }

        //绑定数据
        viewHolder.bindData(province[position]);
        //返回加载完数据的完整视图（不是视图项）
        return convertView;
    }

    /**
     * viewHolder模式
     */
    static class ViewHolder{
        TextView textView_province;
        ImageButton imageButton_next;
        public ViewHolder(View view){
            textView_province = (TextView) view.findViewById(R.id.textView_province);
            imageButton_next = (ImageButton) view.findViewById(R.id.imageButton_next);
        }
        public void bindData(String province){
            textView_province.setText(province);
        }
    }
}
