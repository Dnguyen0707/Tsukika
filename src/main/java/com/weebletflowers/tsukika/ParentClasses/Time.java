package com.weebletflowers.tsukika.ParentClasses;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;


public class Time
{
    //check for current time in 24hrs format UTC
    public static boolean timeCheck(int hour, int minute)
    {
        DateTime currentTime = new DateTime(DateTimeZone.forID("UTC"));
        return (currentTime.getHourOfDay() == hour && currentTime.getMinuteOfHour() == minute && currentTime.getSecondOfMinute() == 0);
    }
}
