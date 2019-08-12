package com.xtruong.scanner.data.prefs;

import com.xtruong.scanner.data.IDataManager;

/**
 * Created by truongtx on 8/11/2019
 */
public interface IPreferencesHelper {

    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(IDataManager.LoggedInMode mode);

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);

    String getCurrentUserProfilePicUrl();

    void setCurrentUserProfilePicUrl(String profilePicUrl);

    String getAccessToken();

    void setAccessToken(String accessToken);
}
