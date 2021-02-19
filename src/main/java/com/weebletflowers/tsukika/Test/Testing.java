package com.weebletflowers.tsukika.Test;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.time.format.DateTimeFormatter;
public class Testing
{
    public static void main(String[] arg)
    {
        DateTime now = new DateTime(DateTimeZone.forID("UTC"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println(now.getHourOfDay() + ":" + now.getMinuteOfHour());
    }
}
