package com.xtruong.scanner.data;

import com.xtruong.scanner.data.db.IDbHelper;
import com.xtruong.scanner.data.network.IApiHelper;
import com.xtruong.scanner.data.prefs.IPreferencesHelper;

import io.reactivex.Observable;

/**
 * Created by truongtx on 8/11/2019
 */
public interface IDataManager extends IPreferencesHelper, IDbHelper, IApiHelper {

    void updateApiHeader(Long userId, String accessToken);

    void setUserAsLoggedOut();

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
