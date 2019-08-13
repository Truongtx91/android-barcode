package com.xtruong.scanner.ui.main;

import com.xtruong.scanner.di.PerActivity;
import com.xtruong.scanner.ui.base.IPresenter;

/**
 * Created by truongtx on 8/13/2019
 */
@PerActivity
public interface IMainPresenter<V extends IMainView> extends IPresenter<V> {

    void onDrawerPaymentClick();

    void onDrawerChangePasswordClick();

    void onDrawerOptionLogoutClick();

    void onDrawerRateUsClick();

    void onDrawerOptionAboutClick();

    void onNavMenuCreated();

    void onViewInitialized();
}
