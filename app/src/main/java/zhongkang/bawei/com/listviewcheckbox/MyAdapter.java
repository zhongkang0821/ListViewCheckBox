package zhongkang.bawei.com.listviewcheckbox;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongkang on 2016/11/2.
 */
public class MyAdapter extends BaseAdapter {

    private List<Bean> listAll;
    private List<Bean> list=new ArrayList<>();
    private Context context;
    private boolean isHide;

    public MyAdapter(List<Bean> list, Context context,boolean isHide) {
        listAll=list;
        this.listAll.addAll(listAll);
        this.context=context;
        this.isHide=isHide;
    }

    public void setHide(boolean isHide){
        this.isHide=isHide;
    }

    public void check(){
        list.clear();
        list.addAll(listAll);
        if(isHide){
            List<Bean> listBean=new ArrayList<>();
            for (Bean bean:list){
                if(bean.isCheck){
                    listBean.add(bean);
                }
            }
            for (int i=0;i<list.size();i++){
                Bean bean=list.get(i);
                    if(bean.isCheck){
                        listBean.add(bean);
                    }
                }
            for (Bean bean:listBean){
                list.remove(bean);
            }
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView=View.inflate(context,R.layout.item,null);
            holder=new ViewHolder();
            holder.text= (TextView) convertView.findViewById(R.id.text);
            holder.checkbox= (CheckBox) convertView.findViewById(R.id.check);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        Bean bean=list.get(position);
        holder.text.setText(bean.text);
        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.get(position).isCheck = isChecked;//stAll当中对应对象的数据同时改变
                check();
            }
        });
        holder.checkbox.setChecked(bean.isCheck);

        return convertView;
    }

    class ViewHolder{
        TextView text;
        CheckBox checkbox;
    }
}