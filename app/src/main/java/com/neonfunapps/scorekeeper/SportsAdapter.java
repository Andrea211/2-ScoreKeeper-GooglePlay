package com.neonfunapps.scorekeeper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SportsAdapter extends BaseAdapter {
    Context context;
    int logos[];
    String namesOfSports[];
    int colors[];
    LayoutInflater inflter;

    public SportsAdapter(Context applicationContext, int[] logos, String[] namesOfSports, int[] colors) {
        this.context = applicationContext;
        this.logos = logos;
        this.namesOfSports = namesOfSports;
        this.colors = colors;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return logos.length;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.grid_item, null); // inflate the layout

        ImageView icon = view.findViewById(R.id.gridItemImage); // get the reference of ImageView
        TextView text = view.findViewById(R.id.gridItemText);

        icon.setImageResource(logos[i]); // set logo images
        text.setText(namesOfSports[i]);

        view.setBackgroundResource(colors[i]);

        return view;
    }
}