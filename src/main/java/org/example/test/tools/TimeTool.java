package org.example.test.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 */
public class TimeTool {

    /**
     * 获取当前系统时间并格式化yyyy-MM-dd HH:mm:ss作为创建时间
     */
    public static String getTime() {
        String time = "";
        time += new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return time;
    }
}
