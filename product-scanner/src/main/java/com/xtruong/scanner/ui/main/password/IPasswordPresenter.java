package com.xtruong.scanner.ui.main.password;

import com.xtruong.scanner.ui.base.IPresenter;

/**
 * Created by truongtx on 8/13/2019
 */
public interface IPasswordPresenter<V extends IPasswordView> extends IPresenter<V> {

    void onOkClicked(String newPassword, String oldPassword);

    void onCancelClicked();
}
