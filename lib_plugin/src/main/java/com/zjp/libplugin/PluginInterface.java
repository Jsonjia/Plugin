package com.zjp.libplugin;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by zjp on 2020/6/30 11:02
 */
public interface PluginInterface {

    void attach(Activity proxyActivity);

    void onCreate(Bundle saveInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void onSaveIntanceState(Bundle outState);

    void onBackPressed();
}
