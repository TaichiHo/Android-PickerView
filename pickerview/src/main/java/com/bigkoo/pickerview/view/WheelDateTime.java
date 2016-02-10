package com.bigkoo.pickerview.view;

import android.content.Context;
import android.view.View;

import com.bigkoo.pickerview.R;
import com.bigkoo.pickerview.TimePickerView.Type;
import com.bigkoo.pickerview.adapter.DateWheelAdapter;
import com.bigkoo.pickerview.adapter.NumericWheelAdapter;
import com.bigkoo.pickerview.lib.WheelView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class WheelDateTime {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private View view;

    // Taichi: Make it a single wheelview combining year, month and day.
    private WheelView wv_date;
    //	private WheelView wv_year;
//	private WheelView wv_month;
//	private WheelView wv_day;
    private WheelView wv_hours;
    private WheelView wv_mins;

    private Type type;
    public static final int DEFULT_START_YEAR = 1990;
    public static final int DEFULT_END_YEAR = 2100;
    private int startYear = DEFULT_START_YEAR;
    private int endYear = DEFULT_END_YEAR;


    public WheelDateTime(View view) {
        super();
        this.view = view;
        type = Type.ALL;
        setView(view);
    }

    public WheelDateTime(View view, Type type) {
        super();
        this.view = view;
        this.type = type;
        setView(view);
    }

    /**
     * @Description: TODO 弹出日期时间选择器
     */
    public void setPicker(int h, int m) {
        Context context = view.getContext();

        WheelView wv_year = (WheelView) view.findViewById(R.id.year);
        WheelView wv_month = (WheelView) view.findViewById(R.id.month);
        WheelView wv_day = (WheelView) view.findViewById(R.id.day);
        wv_year.setVisibility(View.GONE);
        wv_day.setVisibility(View.GONE);
        wv_month.setVisibility(View.GONE);

        wv_date = (WheelView) view.findViewById(R.id.date);
        wv_date.setVisibility(View.VISIBLE);
        wv_date.setAdapter(new DateWheelAdapter());
        wv_date.setCurrentItem(0);


        wv_hours = (WheelView) view.findViewById(R.id.hour);
        wv_hours.setAdapter(new NumericWheelAdapter(0, 23));
        wv_hours.setLabel(context.getString(R.string.pickerview_hours));// 添加文字
        wv_hours.setCurrentItem(h);

        wv_mins = (WheelView) view.findViewById(R.id.min);
        wv_mins.setAdapter(new NumericWheelAdapter(0, 59));
        wv_mins.setLabel(context.getString(R.string.pickerview_minutes));// 添加文字
        wv_mins.setCurrentItem(m);


        // 根据屏幕密度来指定选择器字体的大小(不同屏幕可能不同)
        int textSize = 6;
        switch (type) {
            case ALL:
                textSize = textSize * 3;
                break;
            case YEAR_MONTH_DAY:
                textSize = textSize * 4;
                break;
        }
        wv_date.setTextSize(textSize);
        wv_hours.setTextSize(textSize);
        wv_mins.setTextSize(textSize);

    }

    /**
     * 设置是否循环滚动
     *
     * @param cyclic
     */
    public void setCyclic(boolean cyclic) {
        wv_date.setCyclic(cyclic);
        wv_hours.setCyclic(cyclic);
        wv_mins.setCyclic(cyclic);
    }

    public String getTime() {
        StringBuffer sb = new StringBuffer();
        DateWheelAdapter.MyDate myDate = (DateWheelAdapter.MyDate) wv_date.getAdapter().getItem(wv_date.getCurrentItem());
        sb.append(myDate.getYear()).append("-")
                .append(myDate.getMonth()+1).append("-")
                .append(myDate.getDay()).append(" ")
                .append(wv_hours.getCurrentItem()).append(":")
                .append(wv_mins.getCurrentItem());
        return sb.toString();
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }
}
