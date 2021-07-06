package com.lenovo.managerapp.controlapp.view.fragment;

import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lenovo.managerapp.MainActivity;
import com.lenovo.managerapp.R;
import com.lenovo.managerapp.controlapp.base.BaseFragment;
import com.lenovo.managerapp.controlapp.view.ClickListenerCallback;
import com.lenovo.managerapp.controlapp.view.adapter.ControlListAdapter;
import com.lenovo.managerapp.controlapp.view.bean.GateBean;

import java.util.ArrayList;

public class ControlFragment extends BaseFragment implements View.OnClickListener {

    private Button hotButton;
    private RecyclerView gatelist;
    private Button refresh;

    private boolean isHotOpen;

    private ArrayList<GateBean.Gate> list;

    private MainActivity activity;
    private ControlListAdapter adapter;

    private ClickListenerCallback listener;

    public void setListener(ClickListenerCallback listener) {
        this.listener = listener;
    }

    public void setHotOpen(boolean hotOpen) {
        isHotOpen = hotOpen;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_control;
    }

    @Override
    protected void initView(View view) {
        hotButton = (Button) view.findViewById(R.id.btn_open_controlfragment);
        refresh = (Button) view.findViewById(R.id.btn_refresh_controlfragment);
        gatelist = (RecyclerView) view.findViewById(R.id.recycler_gatelist_controlfragment);

        hotButton.setOnClickListener(this);
        refresh.setOnClickListener(this);

        activity = (MainActivity) getActivity();

        if (isHotOpen) {
            hotButton.setVisibility(View.INVISIBLE);
            gatelist.setVisibility(View.VISIBLE);

            if (list != null) {
                list.clear();
            }
        } else {
            hotButton.setVisibility(View.VISIBLE);
            gatelist.setVisibility(View.INVISIBLE);
        }

        recycler();
    }

    private void recycler() {
        GateBean gatelist = (GateBean) getArguments().getSerializable("gatelist");
        ArrayList<GateBean.Gate> gate = gatelist.gate;

        if (list == null) {
            list = new ArrayList<>();
        }

        list.addAll(gatelist.gate);

        this.gatelist.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new ControlListAdapter(activity, list);
        this.gatelist.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        adapter.setClickListener(new ClickListenerCallback() {
            @Override
            public void toContent(int pos) {
                listener.toContent(pos);
            }

            @Override
            public void backControlFragment() {
                listener.backControlFragment();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_open_controlfragment:
                hotButton.setVisibility(View.INVISIBLE);
                gatelist.setVisibility(View.VISIBLE);
                break;
        }
    }
}
