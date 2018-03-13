package com.example.kihors.crypto.bean.core;

import com.example.kihors.crypto.MainActivity;
import com.example.kihors.crypto.api.DaggerDeps;
import com.example.kihors.crypto.api.Deps;
import com.example.kihors.crypto.api.network.ModuleNetwork;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.io.File;

/**
 * Created by kihors on 24.02.18.
 */

@EBean
public abstract class Bean {

    private Deps deps;

    @RootContext
    public MainActivity activity;

    @AfterInject
    public void init() {
        deps = DaggerDeps.builder().moduleNetwork(new ModuleNetwork(new File(activity.getCacheDir(), "responses"),
                "https://coincap.io/")).build();
    }

    public Deps getDeps() {
        return deps;
    }
}
