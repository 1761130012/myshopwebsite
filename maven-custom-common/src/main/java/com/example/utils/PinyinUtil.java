package com.example.utils;

import com.example.vo.UserShopVo;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 拼音处理类
 * 用于把 中文 转 拼音
 * <p>
 */
public class PinyinUtil {

    static HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();

    static {
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);//小写
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);//纯英文
    }


    /**
     * 生成拼音
     * 特殊：
     * 2.英文不翻译
     *
     * @param name
     */
    public static String getPinyinByString(String name, Character joinChar) {
        StringBuffer output = new StringBuffer();
        //"null".equals(name) 可以避免 name 是空的 报错
        if (name != null && name.length() > 0 && !"null".equals(name)) {
            //trim 前端 尾随空格去除
            char[] input = name.trim().toCharArray();
            try {
                boolean bool=false;
                for (char c : input) {
                    if (java.lang.Character.toString(c).matches(
                            "[\\u4E00-\\u9FA5]+")) {
                        bool=false;
                        //便于区分
                        output.append("|");

                        String[] temp = PinyinHelper.toHanyuPinyinStringArray(c, format);

                        for (String s : temp) {
                            output.append(s);
                        }
                    } else {
                        if(!bool){
                            output.append("|");
                            bool=true;
                        }
                        output.append(c);
                    }

                }
            } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                System.out.println("--------- 中文转拼音异常 --------------");
                badHanyuPinyinOutputFormatCombination.printStackTrace();
            }
        } else {
            return "*";
        }

        String[] strings = output.toString().split("\\|");
        //是否 拼音拼音之间加 符号
        if (joinChar != null && joinChar != ' ') {
            String join = String.join(joinChar.toString(), strings);
            return join.substring(1);
        } else {
            output.delete(0, output.length());
            for (String s : strings) {
                output.append(s);
            }
            return output.toString();
        }
    }

    public static String getPinyinByString(String name) {
        return getPinyinByString(name, null);
    }
}
