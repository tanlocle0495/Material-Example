package com.example.loc.water_body.Activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.loc.water_body.Frament.V4_frament;
import com.example.loc.water_body.R;

public class MainActivity2Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_main_container, V4_frament.newInstance())
                .commit();
    }
    }

