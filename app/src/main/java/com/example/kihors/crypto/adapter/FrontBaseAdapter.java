package com.example.kihors.crypto.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kihors.crypto.R;
import com.example.kihors.crypto.api.model.Front;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kihors on 24.02.18.
 */

public class FrontBaseAdapter extends BaseAdapter {

    private class ViewHolder {
        TextView tvShortName, tvLongName, tvPrice;

        private ViewHolder(View view) {
            tvShortName = view.findViewById(R.id.tv_short_name);
            tvLongName = view.findViewById(R.id.tv_long_name);
            tvPrice = view.findViewById(R.id.tv_price);

        }
    }

    private List<Front> fronts = new ArrayList<>();

    public void setFronts(List<Front> fronts) {
        this.fronts = fronts;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return fronts.size();
    }

    @Override
    public Front getItem(int position) {
        return fronts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_front, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Front front = getItem(position);

        if (front != null) {
            holder.tvLongName.setText(front.getLongName());
            holder.tvShortName.setText(front.getShortName());
            holder.tvPrice.setText(String.valueOf(front.getPrice()));
        }

        return view;
    }
}
