/*
 * Copyright 2015 RSPECTIVE P RYCHLIK SPÓŁKA JAWNA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.loc.lybrarymenu.animation.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;


import com.example.loc.lybrarymenu.animation.DateItem;
import com.example.loc.lybrarymenu.animation.until.DateUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


public abstract class AbsDateAdapter<T extends AbsDateItemHolder> extends RecyclerView.Adapter<T> {

    public static interface DateItemListener {
        void onDateItemClick(DateItem dateItem, int position);
    }
/**/
    protected List<DateItem> dateItems;
    protected DefaultDateAdapter.DateItemListener onDateItemListener;

    protected long selectedDate = -1;
    protected T selectedDateView = null;

    private Animation currentViewAnimation;

    public AbsDateAdapter(Date start, Date end) {
        this(start, end, null);
    }

    public AbsDateAdapter(Date start, Date end, Date defaultDate) {
        if (start.getTime() > end.getTime()) {
            throw new IllegalArgumentException("Wrong dates : StartDate > EndDate");
        }

        this.dateItems = new ArrayList<>();
        this.dateItems.addAll((Collection<? extends DateItem>) DateUtils.getDaysBetweenStartAndEnd(start, end));

        if(defaultDate != null && ((defaultDate.getTime() <= end.getTime() && defaultDate.getTime() >= start.getTime() ))) {
                setSelectedDate(getPosition(defaultDate.getTime()));
        }
    }

    protected abstract void onDateItemHolderClick(T itemHolder);

    protected boolean isDateSelected(DateItem dateItem) {
        return selectedDate == dateItem.getDate().getTime();
    }

    @Override
    public int getItemCount() {
            return dateItems != null ? dateItems.size() : 0;
    }

    public void setOnDateItemClickClistener(DateItemListener onDateItemListener) {
        this.onDateItemListener = onDateItemListener;
    }

    public DateItem getItem(int position) {
        return dateItems.get(position);
    }

    public void setSelectedDate(int position) {
        notifyItemChanged(getPosition(selectedDate));
        selectedDate = dateItems.get(position).getDate().getTime();
        notifyItemChanged(position);
    }

    public int getPosition(long dateInMiliseconds) {
        DateItem dateItem = new DateItem(new Date(dateInMiliseconds));
        return dateItems.indexOf(dateItem);/* gi vào hay muc luc gfi đó cura dateitem*/
    }

    public int getCurrentPosition() {
        return getPosition(selectedDate);
    }

    public Animation getCurrentViewAnimation() {
        return currentViewAnimation;
    }

    public void setCurrentViewAnimation(Animation currentViewAnimation) {
        this.currentViewAnimation = currentViewAnimation;
    }
/* khi no khong rong thi tuc la gia tri nguyen thuy la 1 h*/
    public boolean hasCurrentViewAnimation() {
        return currentViewAnimation != null;
    }
}
