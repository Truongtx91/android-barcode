package com.xtruong.codebase.framework.ui;

/**
 * Created by truongtx on 8/22/2019
 */
public interface IPresenter<V extends IView> {

    void onAttach(V view);

    void onDetach();

    void handleApiError(ANError error);

    void setUserAsLoggedOut();

}
