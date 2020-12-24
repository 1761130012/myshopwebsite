package com.example.utils;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfigUtil {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000116660323";

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCDTfxwpTWyJzwpvHZPrY0XwYeh4TKFaXeJqI575YM7a1EDGxd7Wnxdi7Lt0DmG9oCl5e4Rjr3R3LbgUzXAmWD1JHvk2h9A2/cJZ6HYYeCWQe8Mefr0fd4F1qRJjlh5Jkjz2/Kw+CtvMVIDzU1fe0UdcqsvkCOpTrUE2X6TcJcL2nXjx6/hgTyN7abwc0gDxFNX5AL5f7eAhboHPcjw6T77wmUWEQqGlIy5LWrs7rue1nkpXixtfObNWIcRenleUiU+I4e07P66x8kuiGNF4NmvaedXVBBaLwRXCSo88sbtfsqJmeRTulMjmwYVcXgRIwm9nZ4fuh8Tg1hpm5n+ITtzAgMBAAECggEAYCitteUXtNeM9NfDIUjtKjed18xvTkrVsyeQ6WVEvTAzjP27LagvqeZT7Ftwtckyn8wKlCsgEl/8Qb5OgDUTT5Qfc5LWDo7IlMejPC855XB124I9ae3/ufDeMcwgOODzzjsGudmVHYJWGNiyUDmbfRxsB5Icu7IbWWjajKmIxLF0mCrLMvBRcW2Sckaye5MmhQ6YzbimQ9M8iwG7U5kelhpR3g+sBk25zdQ09R7QIb17XJWt+jXWukfX871Z2cKkxLTI10RAaLmsxSEP1xiSEnLEZpyTWNcGNFKhjBtxHM1jeSTkCR1yooAu0cmB9kJh9zVDH2MMcDrJHrgr8uFqmQKBgQC/dxxwPn+a0db70PYv4AmDWbxRhwFqrO14O+3j45z1eeAX2PccM8FotEDzxfOKA6pZ5mVDTXZoxLJJZeXpg4VOVQ+mwJ7M2hSfhuW/MQxSMitAyUQ6wUdYrRR33HPV6IHcn+pkAhEVh1yLtq2WSuRtwIQY113eXjlNWmJtfnSCfQKBgQCvj9Ez3GbO62D0RdPvxs3/erNjcVgarL7QUHy2sCJIIqc6oyrvV6n3xC5O39QQIg7LvOZCp67iLqfW/r6kpqMt0wY/as7W3EGbXnoB7ihFOep401KRHly6VIoyGogDZLfM+SWElgicp7k6/NwhkaaMtDSe0AFtoPHQQCphH2KorwKBgQCP6ksg/4lQ6PusakQydjcQWSoZKd5hvbv9jSZiDluTlFlh837C3xA40Iyl75wAmIK6cliZPyeK1pagXwxy+p3/5CYQlGaI2j94LaCRlp+JRRaH6wDzHQaw2+AvvDABkHPUTwuSwo7u3MEub1CJUJ/k8zkXpwJyu+Zcg1zKqquOzQKBgQCW25Md6EcjiRkv7gzW3lNHNC2Pxua5TTVOFcuExEdBCx3+AhWzwvWXpSlRt34nOszR/4kxP5vEWej5kr9JBrPzfYDB38rK0EtD8eQPYpGSItk7aANsFdYCewChWzEDEXnrFTBLBQ1zZ6CAcqXJ5rlh8LvCt+RySrlfhLOl7208mwKBgFZhKvxs+ipB9K1Y2wcIVS9jL+p+IPNqSzGYK5qR1kRdzrzdardGIjTidsT/YtZFlYdsWbG3EZK7B7ts3Jxxq+NLZcs5IrAQw58r0Lh3asdAxR0w3hoRiMvHYAqMrGikiYN9pAXmsW0VveVxa96+5+gPed1GeH2C4YCaht2maZi4";

    /**
     * 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
     */
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkH5vLC6X9lHCgh8S1VOJvu4+Exp/nVkrnwPwvVEgkjmskLgEzCTE08WgJdjI3e5CfFRIGjNoa3UviU8JgyQxMLXl71qsj2mcfvnhDVJ6HRwp6YPYaI5qf54KrzRFgPBY48OCnlbj2A95riVaqjep6yizDBScupfcOYqda/V8m0p+a1Hlagi1unIWZzq+gak6hkgVQhkIksuctODQXDjPVW4zUZN9mtIJXmBSKJM41AHg7eWH4fYVDMqRWstrAj3ZOw64RKYGVx92uKiZMm17S8MOeFxQyHuXP/DwA3PJsV7JnvAVcUmWYEdPDzS+OfIgWqGsIngSQR2KNEi6WaA9cQIDAQAB";

    /**
     * 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static String notify_url = "http://localhost:8080/maven_custom_web_war_exploded/alipay/notifyUrl";

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static String return_url = "http://localhost:8080/maven_custom_web_war_exploded/alipay/returnUrl";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";

    public static String format = "json";

    /*public void userPayMoney() {
        //进行初始化
        AlipayClient alipayClient =
                new DefaultAlipayClient(gatewayUrl, app_id, merchant_private_key, "json", charset, alipay_public_key, sign_type);

        AlipayTradePayRequest request = new AlipayTradePayRequest();
        AlipayTradePayModel model = new AlipayTradePayModel();
        request.setBizModel(model);

        model.setOutTradeNo(System.currentTimeMillis()+"");
        model.setSubject("Iphone6 16G");
        model.setTotalAmount("100");
        model.setAuthCode("282728138989572129");//沙箱钱包中的付款码
        model.setScene("bar_code");

        AlipayTradePayResponse response = null;
        try {
            response = alipayClient.execute(request);
            System.out.println(response.getBody());
            System.out.println(response.getTradeNo());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }*/

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

