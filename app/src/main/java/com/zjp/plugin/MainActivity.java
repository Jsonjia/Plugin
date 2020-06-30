package com.zjp.plugin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.zjp.libplugin.PluginManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //跳转插件
    public void skipPlugin(View view) {
        PluginManager.getInstance().setContext(this);
        PluginManager.getInstance().loadPlugin(Environment.getExternalStorageDirectory() + "/orderfood.apk");
        PackageInfo packageInfo = PluginManager.getInstance().getPackageInfo();
        Intent intent = new Intent(MainActivity.this, ProxyActivity.class);
        //由于插件只有一个activity，所以取数组第0个
        intent.putExtra("className", packageInfo.activities[0].name);
        startActivity(intent);
    }
}