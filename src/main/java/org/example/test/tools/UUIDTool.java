package org.example.test.tools;

import java.util.UUID;

public class UUIDTool {
    /**
     * 根据UUID生成数据库各个表的主键ID(32位)
     */
    public static String getUUID() {
        String ID = UUID.randomUUID().toString().replace("-", "");
        return ID;
    }
}
