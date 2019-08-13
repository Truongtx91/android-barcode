package com.xtruong.scanner.ui.main;

import com.xtruong.scanner.ui.base.IPresenter;

/**
 * Created by truongtx on 8/13/2019
 */
public interface IMainPresenter<V extends IMainView> extends IPresenter<V> {

    void onDrawerOptionAboutClick();

    void onDrawerOptionLogoutClick();

    void onNavMenuCreated();

    void onViewInitialized();
}
