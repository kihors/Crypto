package com.example.kihors.crypto.api.network.core;

/**
 * Created by kihors on 24.02.18.
 */

public abstract class BasicNetwork<T> {

    protected final T networkService;

    public BasicNetwork(T networkService) {
        this.networkService = networkService;
    }

    public interface Callback<T> {
        void onSuccess(T t);
    }
}
