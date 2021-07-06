package com.lenovo.managerapp.controlapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lenovo.managerapp.R;
import com.lenovo.managerapp.controlapp.view.ClickListenerCallback;
import com.lenovo.managerapp.controlapp.view.bean.GateBean;

import java.util.ArrayList;

public class ControlListAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<GateBean.Gate> list;

    private ClickListenerCallback clickListener;

    public ControlListAdapter(Context context, ArrayList<GateBean.Gate> list) {
        this.context = context;
        this.list = list;
    }

    public void setClickListener(ClickListenerCallback clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_controlfragment, parent, false);
        return new ControlViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ControlViewHolder viewHolder = (ControlViewHolder) holder;
        GateBean.Gate gate = list.get(position);
        viewHolder.textGatenameItemControlfragment.setText(gate.getName());
        viewHolder.textGatestateItemControlfragment.setText("连接正常");

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.toContent(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ControlViewHolder extends RecyclerView.ViewHolder {
        private TextView textGatenameItemControlfragment;
        private TextView textGatestateItemControlfragment;

        public ControlViewHolder(@NonNull View itemView) {
            super(itemView);
            textGatenameItemControlfragment = (TextView) itemView.findViewById(R.id.text_gatename_item_controlfragment);
            textGatestateItemControlfragment = (TextView) itemView.findViewById(R.id.text_gatestate_item_controlfragment);
        }
    }
}
