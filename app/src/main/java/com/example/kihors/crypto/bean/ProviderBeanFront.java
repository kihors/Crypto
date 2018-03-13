package com.example.kihors.crypto.bean;

import android.widget.ListView;

import com.example.kihors.crypto.adapter.FrontBaseAdapter;
import com.example.kihors.crypto.api.core.BaseView;
import com.example.kihors.crypto.api.model.Front;
import com.example.kihors.crypto.api.network.FrontNetwork;
import com.example.kihors.crypto.api.presenter.FrontPresenter;
import com.example.kihors.crypto.bean.core.Bean;

import org.androidannotations.annotations.EBean;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by kihors on 24.02.18.
 */
@EBean
public class ProviderBeanFront extends Bean implements BaseView<List<Front>> {

    private FrontBaseAdapter frontBaseAdapter;

    @Inject
    FrontNetwork frontNetwork;

    public void initAdapter(ListView listView) {
        getDeps().inject(this);
        new FrontPresenter(frontNetwork, this).getFronts();
        frontBaseAdapter = new FrontBaseAdapter();
        listView.setAdapter(frontBaseAdapter);
    }

    @Override
    public void getSuccess(List<Front> fronts) {
        frontBaseAdapter.setFronts(fronts);
    }
}
