package com.example.zxl.guidepage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zxl.guidepage.R;
import com.example.zxl.guidepage.activity.SelectActivity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/28.
 */

public class SelectAdapter extends RecyclerView.Adapter<SelectAdapter.ViewHolder> implements View.OnClickListener {
    private Context context;
    private List<String> data;
    private LayoutInflater layoutInflater;
    public SelectAdapter(Context context, List<String> data){
        this.context=context;
        this.data=data;
        layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.item_select_recyclerview,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView mTvText=(TextView)holder.itemView.findViewById(R.id.item_select_recyclerview_text);
        mTvText.setText(data.get(position));
        holder.itemView.setOnClickListener(this);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View view) {
        if(onItemClickListener!=null){
            onItemClickListener.OnItemClick(view,(int)view.getTag());
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void OnItemClick(View view,int position);
    }
}
