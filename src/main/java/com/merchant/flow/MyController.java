package com.merchant.flow;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
//@RequestMapping("test")
public class MyController {

    @RequestMapping("test_one")
    @ResponseBody
    public ApiResult<String> test(){
        ApiResult<String> result = new ApiResult<>();
        result.setSuccess(true);
        result.setModel("OK");
        return result;
    }
}
