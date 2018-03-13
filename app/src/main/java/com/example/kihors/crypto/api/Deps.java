package com.example.kihors.crypto.api;

/**
 * Created by kihors on 24.02.18.
 */

import com.example.kihors.crypto.api.network.ModuleNetwork;
import com.example.kihors.crypto.bean.ProviderBeanFront;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ModuleNetwork.class})
public interface Deps {

    void inject(ProviderBeanFront providerBeanFront);
}
