package cn.huangzijian888.aliypay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author huangzijian888
 */
@Controller
public class PaySuccess {
    @GetMapping("/paySuccess")
    public String paySuccess() {
        return "paySuccess";
    }
}
