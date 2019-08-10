package cn.huangzijian888.aliypay.dto;

import lombok.Data;

/**
 * @author huangzijian888
 */
@Data
public class CommonRequestParam {
    /**
     * 支付宝分配给开发者的应用ID
     */
    private String app_id;
    /**
     * 接口名称
     */
    private String method = "alipay.trade.page.pay";
    /**
     * 请求使用的编码格式，如utf-8,gbk,gb2312等
     */
    private String charset = "utf-8";
    /**
     * 商户生成签名字符串所使用的签名算法类型
     */
    private String sign_type = "RSA2";
    /**
     * 商户请求参数的签名串
     */
    private String sign = "RSA2";
    /**
     * 发送请求的时间
     */
    private String timestamp;
    /**
     * 调用的接口版本
     */
    private String version = "1.0";
    /**
     * 请求参数的集合
     */
    private OrderRequestParam biz_content;
}
