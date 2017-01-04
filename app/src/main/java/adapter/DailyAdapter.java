package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ljheee.wearherforecast.R;

import java.util.List;

import bean.Daily_forecast;
import butterknife.Bind;
import butterknife.ButterKnife;
import util.DateUtil;
import util.ImageUtil;


/**
 * Created by wuhaiwen on 2016/6/19.
 */
public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.ViewHolder> {

    List<Daily_forecast> data;
    Context context;
    LayoutInflater inflater;


    public DailyAdapter(List<Daily_forecast> data, Context context) {
        this.data = data;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    /**
     * 创建视图项
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.daily_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView_cond.setImageResource(ImageUtil.Change_Cond_ImageId(data.get(position).getCond().getCond_day()));
        holder.textView_cond.setText(data.get(position).getCond().getCond_day());
        holder.textView_temp.setText(data.get(position).getTmp().getMin() + "°" + "/" + data.get(position).getTmp().getMax() + "°");
        String local_date = data.get(position).getDate();
        holder.textView_daily.setText(DateUtil.FormatDateTime(local_date) +
                    "(" + DateUtil.getWeek(local_date) + ")");
        holder.textView_daily.setText(DateUtil.getWeek(local_date));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.image_daily_cond)
        ImageView imageView_cond;
        @Bind(R.id.tv_daily_cond)
        TextView textView_cond;
        @Bind(R.id.tv_daily_temp)
        TextView textView_temp;
        @Bind(R.id.tv_daily)
        TextView textView_daily;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


//
//    public DailyAdapter(Context context, List<Daily_forecast> data) {
//        this.context = context;
//        this.data = data;
//        inflater = LayoutInflater.from(context);
//    }
//
//    @Override
//    public int getCount() {
//        return data.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return data.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    /**
//     * @param position    数据位置
//     * @param convertView 创建视图
//     * @param parent
//     * @return
//     */
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder viewHolder;
//        if (convertView == null) {
//            convertView = inflater.inflate(R.layout.daily_item, parent, false);
//            viewHolder = new ViewHolder(convertView);
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//        //绑定数据
//        viewHolder.BindData(data.get(position));
//        return convertView;
//    }
//
//    class ViewHolder {
//        @Bind(R.id.image_daily_cond)
//        ImageView imageView_cond;
//        @Bind(R.id.tv_daily_cond)
//        TextView textView_cond;
//        @Bind(R.id.tv_daily_temp)
//        TextView textView_temp;
//        @Bind(R.id.tv_daily)
//        TextView textView_daily;
//
//        public ViewHolder(View view) {
//            ButterKnife.bind(this, view);
//
//        }
//
//        //将数据绑定到控件上
//        public void BindData(Daily_forecast daily_forecast) {
//            imageView_cond.setImageResource(ImageUtil.Change_Cond_ImageId(daily_forecast.getCond().getCond_day()));
//            textView_cond.setText(daily_forecast.getCond().getCond_day());
//            textView_temp.setText(daily_forecast.getTmp().getMin() + "°" + "/" + daily_forecast.getTmp().getMax() + "°");
//            String local_date = daily_forecast.getDate();
////            textView_daily.setText(DateUtil.FormatDateTime(local_date) +
////                    "(" + DateUtil.getWeek(local_date) + ")");
//            textView_daily.setText(DateUtil.getWeek(local_date));
//        }
//
//    }


}
