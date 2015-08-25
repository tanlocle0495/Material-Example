package com.example.loc.lybrarymenu.animation.until;



import com.example.loc.lybrarymenu.animation.DateItem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by loc on 25/04/2015.
 */
public class DateUntils {
    public static List<DateItem> getDaysBetweenStartAndEnd(Date startDate, Date endDate) {
        /* khoi tao mot gia tri list*
         mot phuong thuc mang dung de lay gia tri ve thoi gian bac dau cuxng nhu thoi gian ket thuc
        /
         */
        List<DateItem> List = new ArrayList<DateItem>();
        Calendar calendar = Calendar.getInstance();/* khoi tao mot bien hoi gian*/
        calendar.setTime(startDate);/**/
        /* calendar lay ngay truoc ngay ket thuc*/
        while (calendar.getTime().before(endDate)) {
            Date date = calendar.getTime();/* khoi tao ham ddate va lay gai tri tu
            calendar gan gia tri calendar cho nos
            */
            /* co the lam the nnay*/

//            DateItem d= new DateItem()'
            /*
            * d.setDate(date);
            * list.add(date);
            * */
            List.add(new DateItem(date));
            /* calendar add ngay voi gia tri cua ngay do la 1 ?*/
            calendar.add(Calendar.DATE,1);

        }
        return List;
    }

}
