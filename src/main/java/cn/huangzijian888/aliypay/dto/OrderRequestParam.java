package cn.huangzijian888.aliypay.dto;

import lombok.Data;

/**
 * @author huangzijian888
 */
@Data
public class OrderRequestParam {
    /**
     * 商户订单号
     */
    private String out_trade_no;
    /**
     * 销售产品码，与支付宝签约的产品码名称。
     * 目前仅支持FAST_INSTANT_TRADE_PAY
     */
    private String product_code = "FAST_INSTANT_TRADE_PAY";
    /**
     * 订单总金额，单位为元，精确到小数点后两位，取值范围
     */
    private String total_amount;
    /**
     * 订单标题
     */
    private String subject;

    /**
     * 商品主类型 :0-虚拟类商品,1-实物类商品
     */
    private String goods_type;

    /**
     * 可用渠道,用户只能在指定渠道范围内支付，多个渠道以逗号分割
     */
    private String enable_pay_channels;
}
