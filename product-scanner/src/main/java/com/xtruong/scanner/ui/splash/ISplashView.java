package com.xtruong.scanner.ui.splash;

import com.xtruong.scanner.ui.base.IView;

/**
 * Created by truongtx on 8/22/2019
 */
public interface ISplashView extends IView {

    void openLoginActivity();

    void openMainActivity();

    void startSyncService();
}
