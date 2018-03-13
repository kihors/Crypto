package com.example.kihors.crypto.api.network;

import com.example.kihors.crypto.api.model.Front;
import com.example.kihors.crypto.api.network.core.BasicNetwork;
import com.example.kihors.crypto.api.service.FrontService;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by kihors on 24.02.18.
 */

public class FrontNetwork extends BasicNetwork<FrontService> {

    public FrontNetwork(FrontService networkService) {
        super(networkService);
    }

    public Subscription getFronts(Callback<ArrayList<Front>> arrayListCallback) {

        return networkService.getFrontList().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(Observable::error).subscribe(new Subscriber<ArrayList<Front>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ArrayList<Front> fronts) {
                        arrayListCallback.onSuccess(fronts);
                    }
                });
    }
}
