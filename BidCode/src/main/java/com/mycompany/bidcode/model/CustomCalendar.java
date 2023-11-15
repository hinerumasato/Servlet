/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidcode.model;

import java.util.Calendar;

/**
 *
 * @author thang
 */
public class CustomCalendar {

    private Calendar calendar;

    public CustomCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public String toString() {
        return calendar.get(Calendar.HOUR_OF_DAY) + ":" 
                + calendar.get(Calendar.MINUTE) + ":"
                + calendar.get(Calendar.SECOND)
                + " Ngày "
                + calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.YEAR);
    }
    
    

}
