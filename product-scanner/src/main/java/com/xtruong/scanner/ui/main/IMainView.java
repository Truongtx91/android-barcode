package com.xtruong.scanner.ui.main;

import com.xtruong.scanner.ui.base.IView;

/**
 * Created by truongtx on 8/13/2019
 */
public interface IMainView extends IView {

    void openLoginActivity();

    void showAboutFragment();

    void showBarcodeFragment();

    void closeNavigationDrawer();

    void updateAppVersion();

    void updateUserName(String currentUserName);

    void updateUserEmail(String currentUserEmail);

    void updateUserProfilePic(String profilePicUrl);

    void lockDrawer();

    void unlockDrawer();

    void showRateUsDialog();

    void openPaymentActivity();

    void showChangePasswordDialog();
}
