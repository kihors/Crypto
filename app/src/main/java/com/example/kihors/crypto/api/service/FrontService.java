package com.example.kihors.crypto.api.service;


import com.example.kihors.crypto.api.model.Front;

import java.util.ArrayList;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by kihors on 24.02.18.
 */

public interface FrontService {

    @GET("front")
    Observable<ArrayList<Front>> getFrontList();
}
