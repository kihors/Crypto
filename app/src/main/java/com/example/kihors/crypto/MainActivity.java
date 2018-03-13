package com.example.kihors.crypto;

import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.kihors.crypto.bean.ProviderBeanFront;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)

public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.tv_fronts)
    ListView lvFronts;

    @Bean
    ProviderBeanFront providerBeanFront;

    @AfterViews
    public void bindAdapter() {
        providerBeanFront.initAdapter(lvFronts);
    }
}
