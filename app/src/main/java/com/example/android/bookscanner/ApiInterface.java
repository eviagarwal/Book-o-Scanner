package com.example.android.bookscanner;

import com.example.android.bookscanner.ModelClasses.JsonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Evi on 7/12/2017.
 */

public interface ApiInterface {
    @GET("books/v1/volumes")
    Call<JsonResponse> getBook(@Query("q") String isbn, @Query("key") String key );
}

//?q=isbn:{isbn}&key=AIzaSyCYDpakk-ADzQLL2U0r2L-biF01wOP0m3Q