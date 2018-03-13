package com.example.kihors.crypto.api.presenter.core;

import com.example.kihors.crypto.api.core.BaseView;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by kihors on 24.02.18.
 */

public abstract class Presenter<T, Y> {

    protected final T service;
    protected final BaseView<Y> view;
    protected CompositeSubscription compositeSubscription;

    public Presenter(T service, BaseView<Y> view) {

        this.service = service;
        this.view = view;

        compositeSubscription = new CompositeSubscription();
    }
}
