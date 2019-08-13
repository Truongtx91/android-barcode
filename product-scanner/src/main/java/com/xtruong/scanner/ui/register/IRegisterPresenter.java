package com.xtruong.scanner.ui.register;

import com.xtruong.scanner.ui.base.IPresenter;

/**
 * Created by truongtx on 8/12/2019
 */
public interface IRegisterPresenter<V extends IRegisterView> extends IPresenter<V> {

    void onOKClick(String fullname, String email, String password);

    void onCancelClick();
}
