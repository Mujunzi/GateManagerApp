package com.lenovo.managerapp.controlapp.model;

import com.lenovo.managerapp.controlapp.view.bean.GateBean;
import com.lenovo.managerapp.controlapp.view.bean.LatestVersionBean;

import java.util.ArrayList;

public class ImpModel implements InModel {
    @Override
    public GateBean getHotGateList() {

        ArrayList<GateBean.Gate> gates = new ArrayList<>();

        gates.add(new GateBean.Gate("1号闸机", true, "1.0.2"));
        gates.add(new GateBean.Gate("2号闸机", true, "1.0.3"));
        gates.add(new GateBean.Gate("3号闸机", true, "1.0.2"));
        gates.add(new GateBean.Gate("4号闸机", true, "1.0.2"));
        gates.add(new GateBean.Gate("5号闸机", true, "1.0.3"));
        gates.add(new GateBean.Gate("6号闸机", true, "1.0.2"));

        GateBean gateBean = new GateBean(gates);

        return gateBean;
    }

    @Override
    public void getLatestVersion(VersionCallback callback) {

        ArrayList<LatestVersionBean.Gate> gates = new ArrayList<>();

        gates.add(new LatestVersionBean.Gate("1号闸机", "1.0.3"));
        gates.add(new LatestVersionBean.Gate("2号闸机", "1.0.3"));
        gates.add(new LatestVersionBean.Gate("3号闸机", "1.0.3"));
        gates.add(new LatestVersionBean.Gate("4号闸机", "1.0.3"));
        gates.add(new LatestVersionBean.Gate("5号闸机", "1.0.3"));
        gates.add(new LatestVersionBean.Gate("6号闸机", "1.0.3"));

        LatestVersionBean latestVersionBean = new LatestVersionBean(gates);

        callback.Success(latestVersionBean);

    }
}
