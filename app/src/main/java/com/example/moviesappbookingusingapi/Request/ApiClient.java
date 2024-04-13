package com.example.moviesappbookingusingapi.Request;



import com.example.moviesappbookingusingapi.Util.Credentials;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Credentials.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final ApiInterface apiInterface = retrofit.create(ApiInterface.class);

    public static ApiInterface getMovieApi(){
        return apiInterface;
    }
}
