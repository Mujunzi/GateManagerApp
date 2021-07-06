package com.lenovo.managerapp.controlapp.model;

import com.lenovo.managerapp.controlapp.view.bean.LatestVersionBean;

public interface VersionCallback {
    void Success(LatestVersionBean bean);

    void Fail(String error);
}
