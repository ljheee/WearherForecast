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

import bean.Hourly_forecast;
import bean.Now;
import butterknife.Bind;
import butterknife.ButterKnife;
import util.ImageUtil;

/**
 * Created by wuhaiwen on 2016/6/19.
 */
public class HourAdapter extends RecyclerView.Adapter<HourAdapter.ViewHolder> {

    List<Hourly_forecast> data;
    Context context;
    LayoutInflater inflater;
    String cond;
    Now now;

    public HourAdapter( Context context, List<Hourly_forecast> data,String cond, Now now) {
        this.cond = cond;
        this.context = context;
        this.data = data;
        this.now = now;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.hour_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView_cond.setImageResource(ImageUtil.Change_Cond_ImageId(now.getCond().getCond_day()));
        holder.textView_cond.setText(cond);
        holder.textView_temp.setText(data.get(position).getTmp() + "°");
        holder.textView_hour.setText(data.get(position).getDate().substring(data.get(position).getDate().indexOf(" ")));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.image_hour_cond)
        ImageView imageView_cond;
        @Bind(R.id.tv_hour_cond)
        TextView textView_cond;
        @Bind(R.id.tv_hour_temp)
        TextView textView_temp;
        @Bind(R.id.tv_hour)
        TextView textView_hour;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

//    public HourAdapter(Context context, List<Hourly_forecast> data, String cond, Now now) {
//        this.context = context;
//        this.data = data;
//        this.cond = cond;
//        this.now = now;
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
//            convertView = inflater.inflate(R.layout.hour_item, parent, false);
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
//        @Bind(R.id.image_hour_cond)
//        ImageView imageView_cond;
//        @Bind(R.id.tv_hour_cond)
//        TextView textView_cond;
//        @Bind(R.id.tv_hour_temp)
//        TextView textView_temp;
//        @Bind(R.id.tv_hour)
//        TextView textView_hour;
//
//        public ViewHolder(View view) {
//            ButterKnife.bind(this,view);
//        }
//
//        public void BindData(Hourly_forecast hourly_forecast) {
//            imageView_cond.setImageResource(ImageUtil.Change_Cond_ImageId(now.getCond().getCond_day()));
//            textView_cond.setText(cond);
//            textView_temp.setText(hourly_forecast.getTmp()+"°");
//            textView_hour.setText(hourly_forecast.getDate().substring(hourly_forecast.getDate().indexOf(" ")));
//        }
//
//    }
}
