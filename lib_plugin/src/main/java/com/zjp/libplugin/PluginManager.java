package com.zjp.libplugin;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * Created by zjp on 2020/6/30 14:08
 */
public class PluginManager {

    private Context mContext;

    //插件的资源对象
    private Resources pluginResource;

    //插件的类加载器
    private DexClassLoader dexClassLoader;

    //插件的包信息类
    private PackageInfo packageInfo;

    private static PluginManager pluginManager = new PluginManager();

    private PluginManager() {
    }

    public static PluginManager getInstance() {
        return pluginManager;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    //加载插件apk
    public void loadPlugin(String pluginPath) {
        //获取包管理器
        PackageManager packageManager = mContext.getPackageManager();
        //获取插件的包信息类
        packageInfo = packageManager.getPackageArchiveInfo(pluginPath,
                PackageManager.GET_ACTIVITIES);


        //插件解压后的目录
        File pluginFile = mContext.getDir("plugin", Context.MODE_PRIVATE);

        //获取到类加载器
        dexClassLoader = new DexClassLoader(pluginPath, pluginFile.getAbsolutePath(),
                null, mContext.getClassLoader());

        //获取到插件的资源对象
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPath = assetManager.getClass().getDeclaredMethod("addAssetPath", String.class);
            addAssetPath.invoke(assetManager, pluginPath);
            pluginResource = new Resources(assetManager,
                    mContext.getResources().getDisplayMetrics(),
                    mContext.getResources().getConfiguration());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Resources getPluginResource() {
        return pluginResource;
    }

    public DexClassLoader getDexClassLoader() {
        return dexClassLoader;
    }

    public PackageInfo getPackageInfo() {
        return packageInfo;
    }
}
