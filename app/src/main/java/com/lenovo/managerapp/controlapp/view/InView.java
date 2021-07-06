package com.lenovo.managerapp.controlapp.view;

import com.lenovo.managerapp.controlapp.view.bean.LatestVersionBean;

public interface InView {
    void Success(LatestVersionBean bean);

    void Fail(String error);
}
