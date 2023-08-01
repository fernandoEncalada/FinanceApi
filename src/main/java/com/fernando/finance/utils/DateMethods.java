package com.fernando.finance.utils;

import java.sql.Date;

public class DateMethods {
    public static Date getActualDate(){
        return new Date(System.currentTimeMillis());
    }
}
