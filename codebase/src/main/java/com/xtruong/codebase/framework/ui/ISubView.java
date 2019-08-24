package com.xtruong.codebase.framework.ui;

/**
 * Created by truongtx on 8/22/2019
 */
public interface ISubView extends IView {

    void onCreate();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void attachParentView(IView parentView);
}
