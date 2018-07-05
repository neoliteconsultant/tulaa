package ui.quiz.tulaa.io.quizapp.io;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Webservice endpoints.
 * <p>
 * Copyright (c) July 5, 2018
 *
 * @author <a href="mailto:maganga.tony@eclectic.co.ke">Anthony Wafula</a>
 */

public interface ApiEndpointInterface {

    /**
     * @param econnectRequest
     * @return
     */
    @Headers({
            "Accept:application/json",
            "content-type:application/json",
    })
    @POST("reversetext")
    Call<ResponseBody> postToApi(@Body Map<String, String> econnectRequest);






}
