package com.whitesoul.wsgermmessage.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    // 当前24小时制时间
    public static String nowTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

}
