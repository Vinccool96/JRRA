package com.jrra.arch.http;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HttpClient {

    String API = "/api";

    String V1 = "/v1";

    String AUTHORIZE = "/authorize";

    String CLIENT_ID = "client_id";

    String RESPONSE_TYPE = "response_type";

    String STATE = "state";

    String REDIRECT_URI = "redirect_uri";

    String DURATION = "duration";

    String SCOPE = "scope";

    @GET(API + V1 + AUTHORIZE)
    public Call<ResponseBody> login(@Query(CLIENT_ID) String clientId, @Query(RESPONSE_TYPE) String responseType,
            @Query(STATE) String state, @Query(REDIRECT_URI) String redirectUri, @Query(DURATION) String duration,
            @Query(SCOPE) String scope);

}
