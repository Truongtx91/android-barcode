package com.xtruong.scanner.di.component;

import com.xtruong.scanner.di.PerActivity;
import com.xtruong.scanner.di.module.ActivityModule;
import com.xtruong.scanner.ui.about.AboutFragment;
import com.xtruong.scanner.ui.codereader.BarcodeFragment;
import com.xtruong.scanner.ui.login.LoginActivity;
import com.xtruong.scanner.ui.main.MainActivity;
import com.xtruong.scanner.ui.register.RegisterActivity;

import dagger.Component;

/**
 * Created by truongtx on 8/11/2019
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,  modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity activity);

    void inject(RegisterActivity registerActivity);

    void inject(AboutFragment aboutFragment);

    void inject(BarcodeFragment barcodeFragment);

    void inject(MainActivity mainActivity);
}
