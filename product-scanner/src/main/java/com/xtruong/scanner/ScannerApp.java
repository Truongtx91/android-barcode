package com.xtruong.scanner;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.xtruong.scanner.data.IDataManager;
import com.xtruong.scanner.di.component.ApplicationComponent;
import com.xtruong.scanner.di.component.DaggerApplicationComponent;
import com.xtruong.scanner.di.module.ApplicationModule;
import com.xtruong.scanner.utils.AppLogger;

import javax.inject.Inject;

/**
 * Created by truongtx on 8/10/2019
 */
public class ScannerApp extends Application {


    @Inject
    IDataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {

        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        AppLogger.init();

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
