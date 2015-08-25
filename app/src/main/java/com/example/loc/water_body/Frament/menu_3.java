package com.example.loc.water_body.Frament;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loc.water_body.R;

/**
 * Created by loc on 12/05/2015.
 */
public class menu_3 extends Fragment {


    public static menu_3 newInstance() {
        return new menu_3();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.menu_3,container,false);

        return v;

    }
}
