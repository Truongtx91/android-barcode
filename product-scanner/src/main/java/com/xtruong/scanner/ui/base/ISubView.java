package com.xtruong.scanner.ui.base;

/**
 * Created by truongtx on 8/11/2019
 */
public interface ISubView extends IView {

    void onCreate();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void attachParentMvpView(IView parentView);
}
