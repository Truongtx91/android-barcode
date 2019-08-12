package com.xtruong.scanner.di.component;

import android.app.Application;
import android.content.Context;

import com.xtruong.scanner.ScannerApp;
import com.xtruong.scanner.data.IDataManager;
import com.xtruong.scanner.di.ApplicationContext;
import com.xtruong.scanner.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by truongtx on 8/11/2019
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(ScannerApp app);

    @ApplicationContext
    Context context();

    Application application();

    IDataManager getDataManager();
}
