package com.charthome.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeFormatter {

    private static class TIME_MAXIMUM {
        public static final int SEC = 60;
        public static final int MIN = 60;
        public static final int HOUR = 24;
        public static final int DAY = 7;
        public static final int WEEK = 4;
        public static final int MONTH = 12;
    }

    public static String formatTimeString(LocalDateTime time) {
        LocalDateTime now = LocalDateTime.now();
        long diffTime = ChronoUnit.SECONDS.between(time, now);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String date = null;

        if (diffTime < TIME_MAXIMUM.SEC) {
            date = "방금 전";                 // sec
        } else if ((diffTime /= TIME_MAXIMUM.SEC) < TIME_MAXIMUM.MIN) {
            date = diffTime + " 분 전";         // min
        } else if ((diffTime /= TIME_MAXIMUM.MIN) < TIME_MAXIMUM.HOUR) {
            date = (diffTime) + " 시간 전";     // hour
        } else {
            date = time.format(formatter);
        }
        return date;
    }
}
