package com.example.kihors.crypto.api.network;

import com.example.kihors.crypto.api.service.FrontService;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by kihors on 24.02.18.
 */

@Module
public class ModuleNetwork {

    private File cacheFile;
    private String url;

    public ModuleNetwork(File cacheFile, String url) {
        this.cacheFile = cacheFile;
        this.url = url;
    }

    @Provides
    @Singleton
    Retrofit provideCall() {
        Cache cache = null;
        try {
            cache = new Cache(cacheFile, 10 * 1024 * 1024);
        } catch (Exception e) {
            e.printStackTrace();
        }

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request original = chain.request();

            Request request = original.newBuilder().header("Content-Type", "application/json")
                    .removeHeader("Pragma").header("Cache-Control", String.valueOf(432000)).build();

            Response response = chain.proceed(request);
            response.cacheResponse();
            return response;
        }).cache(cache).build();

        return new Retrofit.Builder().baseUrl(url).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public FrontService providesMessageService(Retrofit retrofit) {
        return retrofit.create(FrontService.class);
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public FrontNetwork providesMessageNetwork(FrontService frontService) {
        return new FrontNetwork(frontService);
    }
}
