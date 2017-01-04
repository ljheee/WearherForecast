package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ljheee.wearherforecast.R;

/**
 * Created by lenovo on 2017/1/2.
 */
public class CityAdapter extends BaseAdapter{
    Context context;
    String[] city;
    LayoutInflater layoutInflater;

    public CityAdapter(Context context,String[] city){
        this.context = context;
        this.city = city;

        layoutInflater = layoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return city.length;
    }

    @Override
    public Object getItem(int position) {
        return city[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_city,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.bindData(city[position]);
        return convertView;
    }

    static class ViewHolder{
        TextView textView_city;
        public ViewHolder(View view){
            textView_city = (TextView) view.findViewById(R.id.textView_city);
        }
        public void bindData(String city){
            textView_city.setText(city);
        }
    }
}
