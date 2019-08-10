package cn.huangzijian888.aliypay.controller;

import cn.huangzijian888.aliypay.dto.OrderRequestParam;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huangzijian888
 */
@RestController
public class PayController {

    @Value("${Alipay.url}")
    private String url;
    @Value("${Alipay.appId}")
    private String appId;
    @Value("${Alipay.appPrivateKey}")
    private String appPrivateKey;
    @Value("${Alipay.alipayPublicKey}")
    private String alipayPublicKeyet;

    @GetMapping("/pay")
    public void pay(@RequestParam("totalAccount") String totalAccount,
                    HttpServletResponse httpServletResponse) throws IOException, AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(url, appId, appPrivateKey, "json", "utf-8", alipayPublicKeyet, "RSA2");
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        OrderRequestParam orderRequestParam = new OrderRequestParam();
        orderRequestParam.setOut_trade_no(RandomStringUtils.random(8, "0123456789"));
        orderRequestParam.setSubject("测试");
        //TODO 增加金额校验
        orderRequestParam.setTotal_amount(totalAccount);
        request.setBizContent(JSONObject.toJSONString(orderRequestParam));
        AlipayTradePagePayResponse response = alipayClient.pageExecute(request);
        httpServletResponse.setContentType("text/html;charset=utf-8");
        httpServletResponse.getWriter().write(response.getBody());
        httpServletResponse.getWriter().flush();
        httpServletResponse.getWriter().close();

//
//        CommonResult commonResult = new CommonResult();
//        commonResult.setCode(1);
//        commonResult.setMsg("测试");
//        return commonResult;
    }
}
