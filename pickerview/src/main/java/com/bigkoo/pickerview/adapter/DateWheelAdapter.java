package com.bigkoo.pickerview.adapter;

import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by Taichi1 on 2/10/16.
 */
public class DateWheelAdapter implements WheelAdapter<DateWheelAdapter.MyDate> {


    public static class MyDate {
        // The value of year, month and day conform to the one in Calendar class.
        int year;
        int month;

        public int getDay() {
            return day;
        }

        public int getYear() {
            return year;
        }

        public int getMonth() {
            return month;
        }

        int day;

        public MyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public String toString() {
            return date2String(year, month, day);
        }
    }

    ArrayList<MyDate> list = new ArrayList<>();

    // 365 days should be enough for now
    int lengthOfDates = 365;

//    public DateWheelAdapter(Calendar startFrom) {
//        new DateWheelAdapter(startFrom, lengthOfDates);
//    }
//
//    public DateWheelAdapter() {
//        new DateWheelAdapter(Calendar.getInstance(TimeZone.getDefault()), lengthOfDates);
//    }
//
//    public DateWheelAdapter(Calendar startFrom, int lengthOfDates) {
//
//        Calendar startDate = Calendar.getInstance(TimeZone.getDefault());
//        startDate.setTime(startFrom.getTime());
//        for (int i = 0; i < lengthOfDates; i++) {
//            startDate.add(Calendar.DATE, 1);
//            list.add(new MyDate(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH),
//                    startDate.get(Calendar.DAY_OF_MONTH)));
//        }
//        Log.i("getItemCountAfterconstrutor", list.size() + "");
//    }

    public DateWheelAdapter(ArrayList<MyDate> myDates) {
        this.list = myDates;
    }

    @Override
    public int getItemsCount() {
        Log.i("getItemCount", list.size() + "");
        return list.size();
    }

    @Override
    public MyDate getItem(int index) {
        return list.get(index);
    }

    @Override
    public int indexOf(MyDate o) {
        return list.indexOf(o);
    }


    public static String date2String(Calendar calendar) {
        return String.format("%s %s %s", getDayOfTheWeek(calendar.get(Calendar.DAY_OF_WEEK)),
                getMonthOfTheYear(calendar.get(Calendar.MONTH)), calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static String date2String(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        return date2String(calendar);

    }

    private static String getDayOfTheWeek(int day) {
        switch (day) {
            case 1:
                return "Sun";
            case 2:
                return "Mon";
            case 3:
                return "Tue";
            case 4:
                return "Wed";
            case 5:
                return "Thu";
            case 6:
                return "Fri";
            case 7:
                return "Sat";
        }
        return "null";
    }

    private static String getMonthOfTheYear(int month) {
        switch (month) {
            case 0:
                return "Jan";
            case 1:
                return "Feb";
            case 2:
                return "Mar";
            case 3:
                return "Apr";
            case 4:
                return "May";
            case 5:
                return "Jun";
            case 6:
                return "Jul";
            case 7:
                return "Aug";
            case 8:
                return "Sep";
            case 9:
                return "Oct";
            case 10:
                return "Nov";
            case 11:
                return "Dec";
        }
        return "null";
    }

}
