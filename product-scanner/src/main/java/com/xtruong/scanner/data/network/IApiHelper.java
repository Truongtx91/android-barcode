package com.xtruong.scanner.data.network;

import com.xtruong.scanner.data.network.model.ImportItemRequest;
import com.xtruong.scanner.data.network.model.LoginRequest;
import com.xtruong.scanner.data.network.model.LoginResponse;
import com.xtruong.scanner.data.network.model.LogoutResponse;

import io.reactivex.Single;

/**
 * Created by truongtx on 8/11/2019
 */
public interface IApiHelper {

    ApiHeader getApiHeader();

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Single<LogoutResponse> doLogoutApiCall();

    Single<ImportItemRequest> doImportApiCall();
}
