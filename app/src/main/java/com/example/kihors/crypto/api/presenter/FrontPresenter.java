package com.example.kihors.crypto.api.presenter;

import com.example.kihors.crypto.api.core.BaseView;
import com.example.kihors.crypto.api.model.Front;
import com.example.kihors.crypto.api.network.FrontNetwork;
import com.example.kihors.crypto.api.network.core.BasicNetwork;
import com.example.kihors.crypto.api.presenter.core.Presenter;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

/**
 * Created by kihors on 24.02.18.
 */

public class FrontPresenter extends Presenter<FrontNetwork, List<Front>> {

    public FrontPresenter(FrontNetwork service, BaseView<List<Front>> view) {
        super(service, view);
    }

    public void getFronts() {
        Subscription subscription = service.getFronts(new BasicNetwork.Callback<ArrayList<Front>>() {
            @Override
            public void onSuccess(ArrayList<Front> fronts) {
                view.getSuccess(fronts);
            }
        });
        compositeSubscription.add(subscription);
    }
}
