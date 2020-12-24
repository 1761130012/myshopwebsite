package com.example.utils;

import com.github.pagehelper.util.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

/**
 * 删除 类的字段 或者 文字 中 的 前后 空格 和 空串  空串返回 null
 * @author LLY
 */
public class DelSpaceEmpty {

    /**
     * 处理 类
     * 对 每个 字段 进行 获取值 并 进行 判断 在 赋值
     */
    public static <T> T disposeVoString(T object) {
        Class<?> objectClass = object.getClass();
        Field[] fields = objectClass.getDeclaredFields();
        try {
            for (Field field : fields) {
                String fieldName = field.getName();
                if (!fieldName.equals("serialVersionUID") && field.getType().getName().contains("String")) {
                    //允许 读取 私有 字段
                    field.setAccessible(true);
                    String value = (String) field.get(object);
                    value = StringUtils.isEmpty(value) ? null : value.trim();
                    field.set(object, StringUtils.isEmpty(value) ? null : value);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 处理 string  是否 是 null 和 空串 不是 就 去除 首尾空格 在判断一次
     */
    public static String disposeString(String str) {
        return StringUtil.isEmpty(str) ? null : StringUtils.isEmpty(str.trim()) ? null : str.trim();
    }
}
