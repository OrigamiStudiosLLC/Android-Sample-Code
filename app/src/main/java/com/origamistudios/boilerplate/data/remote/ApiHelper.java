package com.origamistudios.boilerplate.data.remote;

import com.origamistudios.boilerplate.data.model.api.BlogResponse;
import com.origamistudios.boilerplate.data.model.api.LoginRequest;
import com.origamistudios.boilerplate.data.model.api.LoginResponse;
import com.origamistudios.boilerplate.data.model.api.LogoutResponse;
import com.origamistudios.boilerplate.data.model.api.OpenSourceResponse;

import io.reactivex.Single;

public interface ApiHelper {

    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Single<LogoutResponse> doLogoutApiCall();

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    ApiHeader getApiHeader();

    Single<BlogResponse> getBlogApiCall();

    Single<OpenSourceResponse> getOpenSourceApiCall();
}
