package com.xtruong.scanner.data.network;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.xtruong.scanner.data.network.model.ImportItemRequest;
import com.xtruong.scanner.data.network.model.LoginRequest;
import com.xtruong.scanner.data.network.model.LoginResponse;
import com.xtruong.scanner.data.network.model.LogoutResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by truongtx on 8/12/2019
 */
@Singleton
public class AppApiHelper implements IApiHelper{

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LogoutResponse> doLogoutApiCall() {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectSingle(LogoutResponse.class);
    }

    @Override
    public Single<ImportItemRequest> doImportApiCall() {
        //TODO
        return null;
    }


}
