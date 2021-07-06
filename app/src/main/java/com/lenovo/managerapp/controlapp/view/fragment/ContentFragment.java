package com.lenovo.managerapp.controlapp.view.fragment;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lenovo.managerapp.R;
import com.lenovo.managerapp.controlapp.base.BaseFragment;
import com.lenovo.managerapp.controlapp.view.ClickListenerCallback;
import com.lenovo.managerapp.controlapp.view.bean.GateBean;
import com.lenovo.managerapp.controlapp.view.bean.LatestVersionBean;

public class ContentFragment extends BaseFragment implements View.OnClickListener {

    private ClickListenerCallback listenerCallback;

    private TextView name;
    private Button back;
    private Button updata;
    private GateBean.Gate gate;
    private LatestVersionBean.Gate latest;

    private String latestVersion;
    private String currentVersion;

    public void setListenerCallback(ClickListenerCallback listenerCallback) {
        this.listenerCallback = listenerCallback;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_content;
    }

    @Override
    protected void initView(View view) {
        gate = (GateBean.Gate) getArguments().getSerializable("gate");
        latest = (LatestVersionBean.Gate) getArguments().getSerializable("latest");
        currentVersion = gate.getCurrent_version();
        if (latest != null) {
            latestVersion = latest.getLatest_Version();
        }

        Log.e("c/l", currentVersion + "/" + latestVersion);

        name = (TextView) view.findViewById(R.id.text_gatename_contentfragment);
        back = (Button) view.findViewById(R.id.btn_back_contentfragment);
        updata = (Button) view.findViewById(R.id.btn_checkupdata_contentfragment);

        back.setOnClickListener(this);
        updata.setOnClickListener(this);
        name.setText(gate.name);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back_contentfragment:
                listenerCallback.backControlFragment();
                break;
            case R.id.btn_checkupdata_contentfragment:
                Toast.makeText(getActivity(), "检测！", Toast.LENGTH_SHORT).show();
//                if (!gate.getCurrent_version().equals(latest.getLatest_Version())) {
//                    updata.setText("有最新版本" + latest.getLatest_Version());
//                    updata.setTextColor(Color.RED);
//                }
                break;
        }
    }
}
