package com.zjp.orderfood;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.zjp.libplugin.PluginInterface;

/**
 * Created by zjp on 2020/6/30 11:19
 */
public class BaseActivity extends Activity implements PluginInterface {

    private Activity mProxyActivity;

    @Override
    public void attach(Activity proxyActivity) {
        this.mProxyActivity = proxyActivity;
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onCreate(Bundle saveInstanceState) {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onStart() {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onResume() {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onPause() {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onStop() {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onDestroy() {

    }

    @Override
    public void onSaveIntanceState(Bundle outState) {

    }

    @Override
    public void setContentView(View view) {
        if (null != mProxyActivity) {
            mProxyActivity.setContentView(view);
        } else
            super.setContentView(view);
    }

    @Override
    public void setContentView(int layoutResID) {
        if (null != mProxyActivity) {
            mProxyActivity.setContentView(layoutResID);
        } else
            super.setContentView(layoutResID);
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return mProxyActivity.findViewById(id);
    }

    @Override
    public Intent getIntent() {
        return mProxyActivity.getIntent();
    }

    @Override
    public ClassLoader getClassLoader() {
        return mProxyActivity.getClassLoader();
    }
}
