package ui.quiz.tulaa.io.quizapp.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ui.quiz.tulaa.io.quizapp.io.ApiEndpointInterface;

/**
 * Configuration settings for the app
 * <p>
 * Copyright (c) Eclectic Kenya Ltd., July 5, 2018
 *
 * @author <a href="mailto:tonyafula@gmail.com">Anthony Wafula</a>
 */
public class Config {
    public static final String BASE_URL = "http://[ipaddress]:8097/api/v1/quiz/";



    /**
     * Get absolute url.
     *
     * @param relativeUrl
     * @return
     */
    public static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }

    public static ApiEndpointInterface getAPIService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiEndpointInterface apiService =
                retrofit.create(ApiEndpointInterface.class);

        return apiService;
    }


}
