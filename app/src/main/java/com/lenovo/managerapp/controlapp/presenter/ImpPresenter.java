package com.lenovo.managerapp.controlapp.presenter;

import com.lenovo.managerapp.controlapp.model.ImpModel;
import com.lenovo.managerapp.controlapp.model.InModel;
import com.lenovo.managerapp.controlapp.model.VersionCallback;
import com.lenovo.managerapp.controlapp.view.InView;
import com.lenovo.managerapp.controlapp.view.bean.GateBean;
import com.lenovo.managerapp.controlapp.view.bean.LatestVersionBean;

public class ImpPresenter implements InPresenter {

    private InView view;
    private InModel model;

    public ImpPresenter(InView view) {
        this.view = view;
        model = getModel();
    }

    private InModel getModel() {
        return new ImpModel();
    }

    @Override
    public GateBean getHotGate() {
        return model.getHotGateList();
    }

    @Override
    public void getLatestVersion() {
        model.getLatestVersion(new VersionCallback() {
            @Override
            public void Success(LatestVersionBean bean) {
                view.Success(bean);
            }

            @Override
            public void Fail(String error) {
                view.Fail(error);
            }
        });
    }
}
