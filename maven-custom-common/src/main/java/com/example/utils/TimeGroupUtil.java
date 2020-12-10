package com.example.utils;

import com.example.enums.TimeGroupCaseEnum;
import com.example.exceptions.CharacterNotLetterBoundsException;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TimeGroupUtil {
    private final static String PATTERN = "yyyyMMddHHmmssS";

    /**
     * 生成 id
     *
     * @param head          头部英文
     * @param tail          尾部英文
     * @param timeGroupCase 头部尾部额外的 大小写 默认是大写
     * @return
     */
    public static String getTimeGroupId(String head, String tail, TimeGroupCaseEnum timeGroupCase) {
        SimpleDateFormat format = new SimpleDateFormat(PATTERN);
        String time = format.format(new Date());

        if (verifyString(head)) {
            time = changeCase(head, timeGroupCase) + time;
        }
        if (verifyString(tail)) {
            time = time + changeCase(tail, timeGroupCase);
        }

        return time;
    }

    private static boolean verifyString(String str) {
        boolean flag = true;
        if (StringUtils.isEmpty(str)) {
            flag = false;
        } else {
            if (!str.matches("^\\w+$")) {
                flag = false;
                try {
                    throw new CharacterNotLetterBoundsException();
                } catch (CharacterNotLetterBoundsException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    private static String changeCase(String str, TimeGroupCaseEnum timeGroupCase) {
        String ans;
        //只要没有明确表明是 大写
        if (timeGroupCase != TimeGroupCaseEnum.LOWER_CASE) {
            ans = str.toUpperCase();
        } else {
            ans = str.toLowerCase();
        }
        return ans;
    }

    public static String getTimeGroupHeadId(String head) {
        return getTimeGroupId(head, null, null);
    }

    public static String getTimeGroupHeadId(String head, TimeGroupCaseEnum timeGroupCase) {
        return getTimeGroupId(head, null, timeGroupCase);
    }

    public static String getTimeGroupTailId(String tail) {
        return getTimeGroupId(null, tail, null);
    }

    public static String getTimeGroupTailId(String tail, TimeGroupCaseEnum timeGroupCase) {
        return getTimeGroupId(null, tail, timeGroupCase);
    }

    public static String getTimeGroupId() {
        return getTimeGroupId(null, null, null);
    }
}
