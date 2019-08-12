package com.xtruong.scanner.ui.base;

import com.androidnetworking.error.ANError;

/**
 * Created by truongtx on 8/11/2019
 */
public interface IPresenter<V extends  IView> {

    void onAttach(V currentView);

    void onDetach();

    void handleApiError(ANError error);

    void setUserAsLoggedOut();
}
