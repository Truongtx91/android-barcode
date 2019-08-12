package com.xtruong.scanner.ui.login;

import com.xtruong.scanner.ui.base.IView;

/**
 * Created by truongtx on 8/11/2019
 */
public interface ILoginView extends IView {

    void openMainActivity();

    void openRegisterActivity();

    void openForgotPasswordDialog();
}
