package com.example.loc.water_body.Frament;


import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.loc.lybrarymenu.animation.Adapter.DatePagerFragmentAdapter;
import com.example.loc.lybrarymenu.animation.Adapter.DefaultDateAdapter;
import com.example.loc.lybrarymenu.animation.DateItem;
import com.example.loc.lybrarymenu.animation.PagerDatePickerDateFormat;
import com.example.loc.lybrarymenu.animation.View.DateRecyclerView;
import com.example.loc.lybrarymenu.animation.View.RecyclerViewInsetDecoration;
import com.example.loc.water_body.R;
import com.example.loc.water_body.Until.SimplePageFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by loc on 12/05/2015.
 */
public class User_frament_lenLich extends Fragment {
    private DateRecyclerView dateList;
    private ViewPager pager;


    public static User_frament_lenLich newInstance() {
        return new User_frament_lenLich();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_lenlich, container, false);


        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pager = (ViewPager) view.findViewById(R.id.pager);
        dateList = (DateRecyclerView) view.findViewById(R.id.date_list);
        dateList.addItemDecoration(new RecyclerViewInsetDecoration(getActivity(), R.dimen.date_card_insets));
        Date start = null;
        Date end = null;
        Date defaultDate = null;

        try {

            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            start = PagerDatePickerDateFormat.DATE_PICKER_DD_MM_YYYY_FORMAT.parse("02-12-2000");
            end = PagerDatePickerDateFormat.DATE_PICKER_DD_MM_YYYY_FORMAT.parse("02-12-2020");

            defaultDate = PagerDatePickerDateFormat.DATE_PICKER_DD_MM_YYYY_FORMAT.parse(format.format(date.getTime()));


        } catch (Exception e) {
            Log.e("Error:", e.toString());
        }
        dateList.setAdapter(new DefaultDateAdapter(start, end, defaultDate));

        dateList.setAdapter(new DefaultDateAdapter(start, end, defaultDate));

        DatePagerFragmentAdapter fragmentAdapter = new DatePagerFragmentAdapter(getFragmentManager(), dateList.getDateAdapter()) {
            @Override
            protected Fragment getFragment(int position, long date) {
                return SimplePageFragment.newInstance(position, date);
            }
        };

        pager.setAdapter(fragmentAdapter);
        dateList.setPager(pager);

        dateList.setDatePickerListener(new DateRecyclerView.DatePickerListener() {
            @Override
            public void onDatePickerItemClick(DateItem dateItem, int position) {
                Toast.makeText(getActivity(), "Clicked: " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDatePickerPageSelected(int position) {

            }

            @Override
            public void onDatePickerPageStateChanged(int state) {

            }

            @Override
            public void onDatePickerPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
        });
    }
}
