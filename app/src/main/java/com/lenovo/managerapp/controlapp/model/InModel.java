package com.lenovo.managerapp.controlapp.model;

import com.lenovo.managerapp.controlapp.view.bean.GateBean;

public interface InModel {
    GateBean getHotGateList();

    void getLatestVersion(VersionCallback callback);
}
