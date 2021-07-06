package com.lenovo.managerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.lenovo.managerapp.controlapp.presenter.ImpPresenter;
import com.lenovo.managerapp.controlapp.presenter.InPresenter;
import com.lenovo.managerapp.controlapp.view.ClickListenerCallback;
import com.lenovo.managerapp.controlapp.view.InView;
import com.lenovo.managerapp.controlapp.view.bean.GateBean;
import com.lenovo.managerapp.controlapp.view.bean.LatestVersionBean;
import com.lenovo.managerapp.controlapp.view.fragment.ContentFragment;
import com.lenovo.managerapp.controlapp.view.fragment.ControlFragment;

public class MainActivity extends AppCompatActivity implements InView {

    private InPresenter presenter;

    private ContentFragment contentFragment;
    private ControlFragment controlFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new ImpPresenter(this);

        controlFragment = new ControlFragment();
        contentFragment = new ContentFragment();

        checkNecessaryPermission();
    }

    private void checkNecessaryPermission() {

        toControlFragment(false);

    }

    private void toControlFragment(boolean isHotOpen) {

        if (controlFragment == null) {
            controlFragment = new ControlFragment();
        }

        Bundle bundle = new Bundle();
        GateBean hotGate = presenter.getHotGate();
        bundle.putSerializable("gatelist", hotGate);
        controlFragment.setArguments(bundle);

        if (fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
        }

        fragmentManager.beginTransaction()
                .replace(R.id.framelayout_main, controlFragment)
                .commit();

        controlFragment.setHotOpen(isHotOpen);

        controlFragment.setListener(new ClickListenerCallback() {
            @Override
            public void toContent(int pos) {
                toContentFragment(pos);
            }

            @Override
            public void backControlFragment() {

            }
        });
    }

    private void toContentFragment(int pos) {

        presenter.getLatestVersion();

        if (contentFragment == null) {
            contentFragment = new ContentFragment();
        }

        Bundle bundle = new Bundle();
        GateBean hotGate = presenter.getHotGate();
        bundle.putSerializable("gate", hotGate.gate.get(pos));
        contentFragment.setArguments(bundle);

        if (fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
        }

        fragmentManager.beginTransaction()
                .replace(R.id.framelayout_main, contentFragment)
                .commit();

        contentFragment.setListenerCallback(new ClickListenerCallback() {
            @Override
            public void toContent(int pos) {

            }

            @Override
            public void backControlFragment() {
                toControlFragment(true);
            }
        });
    }

    @Override
    public void Success(LatestVersionBean bean) {
        if (contentFragment == null) {
            contentFragment = new ContentFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("latest", bean);
        contentFragment.setArguments(bundle);
    }

    @Override
    public void Fail(String error) {

    }
}