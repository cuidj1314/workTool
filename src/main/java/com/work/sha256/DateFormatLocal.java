package com.work.sha256;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatLocal {

    // フォーマット
    public static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static void interfaceTest() {
        try {
            // ADの日付（例：133086552081957971）
            String strDate1 = "11644570800000";
            // 日付
            String strDate2 = "2022-09-27 11:00:00";
            System.out.println("出力日期：" + DateFormatLocal.MillisecondsToDate(strDate1));
            System.out.println("出力毫秒：" + DateFormatLocal.DateToMilliseconds(strDate2) + "0000");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param str
     * @return
     * @throws ParseException
     */
    private static long DateToMilliseconds(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        Date d = (Date) sdf.parseObject(str);
        return d.getTime() + 11644473600000L;
    }

    /**
     * @param strDate
     * @return
     */
    private static String MillisecondsToDate(String strDate) {
        long lEdit = Long.parseLong(strDate.substring(0, 14)) - 11644473600000L;
        Date date = new Date(lEdit);
        date.setTime(lEdit);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(date);
    }
}
