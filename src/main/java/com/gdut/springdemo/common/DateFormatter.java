package com.gdut.springdemo.common;

import org.apache.log4j.Logger;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Jun on 2016/9/10.
 */
public class DateFormatter implements Formatter<Date> {

    Logger log = Logger.getLogger(DateFormatter.class);

    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        log.info("formatter parse.............");
        return simpleDateFormat.parse(s);
    }

    @Override
    public String print(Date date, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        log.info("formatter format.............");
        return simpleDateFormat.format(date);
    }
}
