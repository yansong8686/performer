package com.mys.java8.newFeature.feature2;

import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * 日期时间 API
 * Java 8通过发布新的Date-Time API (JSR 310)来进一步加强对日期与时间的处理。
 * 在旧版的 Java 中，日期时间 API 存在诸多问题，其中有：
 *  非线程安全 − java.util.Date 是非线程安全的，所有的日期类都是可变的，这是Java日期类最大的问题之一。
 * 设计很差 − Java的日期/时间类的定义并不一致，在java.util和java.sql的包中都有日期类，此外用于格式化和解析的类在java.text包中定义。
 * java.util.Date同时包含日期和时间，而java.sql.Date仅包含日期，将其纳入java.sql包并不合理。另外这两个类都有相同的名字，这本身就是一个非常糟糕的设计。
 * 时区处理麻烦 − 日期类并不提供国际化，没有时区支持，因此Java引入了java.util.Calendar和java.util.TimeZone类，但他们同样存在上述所有的问题。
 * Java 8 在 java.time 包下提供了很多新的 API。以下为两个比较重要的 API：
 * Local(本地) − 简化了日期时间的处理，没有时区的问题。
 * Zoned(时区) − 通过制定的时区处理日期时间。
 * 新的java.time包涵盖了所有处理日期，时间，日期/时间，时区，时刻（instants），过程（during）与时钟（clock）的操作
 * Created by manyansong on 2016/11/7.
 */
public class NewDateTimeTest {
    public static void main(String[] args) {
        testLocalDateTime();
    }


    public static void testLocalDateTime(){

        // 获取当前的日期时间
        LocalDateTime currentDateAndTime = LocalDateTime.now(); //获取本地日期和时间
        System.out.println("当前日期时间: " + currentDateAndTime);//当前时间: 2016-11-07T19:20:35.528

        // 获取当前的时间
        LocalTime currentTime = LocalTime.now(); //获取本地时间
        System.out.println("当前时间: " + currentTime);//当前时间: 19:20:35.528

        LocalDate date0 = LocalDate.now(); //获取本地日期
        System.out.println("date0: " + date0);//date0: 2016-11-07

        LocalDate date1 = currentDateAndTime.toLocalDate(); //获取本地日期
        System.out.println("date1: " + date1);

        //a.在Java 8中如何检查两个日期是否相等****
        LocalDate dateA = LocalDate.of(2016, 11, 07);
        if(dateA.equals(date0)){
            System.out.printf("Today is %s and dateA is %s are same date %n", date0, dateA);
        }

        //b.在Java 8中如何检查重复事件，比如说生日
        // MonthDay的用法：这个类由月日组合，不包含年信息，也就是说你可以用它来代表每年重复出现的一些日子
        // 类似的有YearMonth类
        LocalDate dateOfBirth = LocalDate.of(2016, 11, 07);
        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(date0);
        System.out.printf("currentMonthDay is %s,birthday is %s\n",currentMonthDay,birthday);
        if(currentMonthDay.equals(birthday)){
            System.out.println("Many Many happy returns of the day !!");
        }else{
            System.out.println("Sorry, today is not your birthday");
        }

        //c.如何增加时间里面的小时数
        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(2); // adding two hours
        System.out.println("Time after 2 hours : " + newTime);

        //d.在Java 8中如何获取当前时间戳
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp);//What is value of this instant 2016-11-07T11:47:01.450Z

        //e. 如何在Java 8中使用预定义的格式器来对日期进行解析/格式化
        String dayAfterTommorrow = "20161108";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow,
                DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);//Date generated from String 20161108 is 2016-11-08

        //f.如何在Java中使用自定义的格式器来解析日期
        String goodFriday = "20161107195500";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            LocalDateTime holiday = LocalDateTime.parse(goodFriday, formatter);
            System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
        } catch (DateTimeParseException ex) {
            System.out.printf("%s is not parsable!%n", goodFriday);
            ex.printStackTrace();
        }

        //g.如何在Java 8中对日期进行格式化，转换成字符串
        LocalDateTime arrivalDate = LocalDateTime.now();
        System.out.println(arrivalDate);
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String landing = arrivalDate.format(format);
            System.out.printf("Arriving at : %s %n", landing);//2016-11-07 19:59:49
        } catch (DateTimeException ex) {
            System.out.printf("%s can't be formatted!%n", arrivalDate);
            ex.printStackTrace();
        }

        LocalDate endofCentury = LocalDate.of(2016, 11, 14);
        LocalDate now = LocalDate.now();

        Period diff = Period.between(endofCentury, now);

        System.out.printf("The 21st century (up to %s) is %s old%n", now, diff);
        System.out.printf("The 21st century is %d years, %d months and %d days old\n",
                diff.getYears(), diff.getMonths(), diff.getDays());

        //获取当前的年月日
        Month month = currentDateAndTime.getMonth();
        int day = currentDateAndTime.getDayOfMonth();
        int seconds = currentDateAndTime.getSecond();

        System.out.println("月: " + month +", 日: " + day +", 秒: " + seconds);

        LocalDateTime date2 = currentDateAndTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        //关于这个方法还有一个好消息就是它没有再犯之前API中的错，比方说，年只能从1900年开始，月必须从0开始，等等
        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);//指定2014年12月12号
        System.out.println("date3: " + date3);

        // 22 小时 15 分钟
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);//date4: 22:15

        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);

        LocalTime begin = LocalTime.parse("13:45");
        LocalTime end = LocalTime.parse("13:47");
        System.out.println("begin="+begin.getNano());
        System.out.println("begin="+begin.getMinute());

        //Clock可以替代System.currentTimeMillis()和TimeZone.getDefault()。
        final Clock clock = Clock.systemUTC();
        System.out.println( clock.instant() );
        System.out.println( clock.millis() );
    }
}
