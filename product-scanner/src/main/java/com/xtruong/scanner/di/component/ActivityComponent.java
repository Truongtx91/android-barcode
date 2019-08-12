package com.xtruong.scanner.di.component;

import com.xtruong.scanner.di.PerActivity;
import com.xtruong.scanner.di.module.ActivityModule;
import com.xtruong.scanner.ui.login.LoginActivity;
import com.xtruong.scanner.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by truongtx on 8/11/2019
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,  modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity activity);
}
