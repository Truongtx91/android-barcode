package com.xtruong.scanner.data;

import android.content.Context;

import com.xtruong.scanner.data.db.IDbHelper;
import com.xtruong.scanner.data.db.model.User;
import com.xtruong.scanner.data.network.ApiHeader;
import com.xtruong.scanner.data.network.IApiHelper;
import com.xtruong.scanner.data.network.model.ImportItemRequest;
import com.xtruong.scanner.data.network.model.LoginRequest;
import com.xtruong.scanner.data.network.model.LoginResponse;
import com.xtruong.scanner.data.network.model.LogoutResponse;
import com.xtruong.scanner.data.prefs.IPreferencesHelper;
import com.xtruong.scanner.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by truongtx on 8/12/2019
 */
@Singleton
public class AppDataManager implements IDataManager {


    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final IDbHelper mDbHelper;
    private final IPreferencesHelper mPreferencesHelper;
    private final IApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          IDbHelper dbHelper,
                          IPreferencesHelper preferencesHelper,
                          IApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public void updateApiHeader(Long userId, String accessToken) {
        mApiHelper.getApiHeader().getProtectedApiHeader().setUserId(userId);
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(
                null,
                null,
                IDataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT);
    }

    @Override
    public void updateUserInfo(String accessToken, Long userId, LoggedInMode loggedInMode) {
        setAccessToken(accessToken);
        setCurrentUserId(userId);
        setCurrentUserLoggedInMode(loggedInMode);

        updateApiHeader(userId, accessToken);
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public Long getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        mPreferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPreferencesHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        mPreferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mPreferencesHelper.getCurrentUserProfilePicUrl();
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        mPreferencesHelper.setCurrentUserProfilePicUrl(profilePicUrl);
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public Observable<Long> insertUser(User user) {
        return mDbHelper.insertUser(user);
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return mDbHelper.getAllUsers();
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return mApiHelper.doServerLoginApiCall(request);
    }

    @Override
    public Single<LogoutResponse> doLogoutApiCall() {
        return mApiHelper.doLogoutApiCall();
    }

    @Override
    public Single<ImportItemRequest> doImportApiCall() {
        return mApiHelper.doImportApiCall();
    }
}
