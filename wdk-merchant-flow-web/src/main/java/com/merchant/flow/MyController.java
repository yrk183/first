package com.merchant.flow;

import com.merchant.flow.domain.StudentDO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("test")
public class MyController {

    @GetMapping("test_first")
    @ResponseBody
    public ApiResult<String> test(){
        ApiResult<String> result = new ApiResult<>();
        List<String> list = new ArrayList<>();
        List<Integer> listLenth = list.stream().map(x -> x.length()).collect(Collectors.toList());
        Map<Integer, String> lengthMap = list.stream().collect(Collectors.toMap(x -> x.length(), x -> x, (k1, k2) -> k2));
        for (Map.Entry<Integer, String> entry : lengthMap.entrySet()) {
            entry.getKey();
            entry.getValue();
        }
        List<String> collect = list.stream().filter(x -> x.length() > 0).sorted(Comparator.comparing(x -> x.length())).collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }
        result.setSuccess(true);
        result.setModel("OKokok");
        return result;
    }

    @PostMapping("test_push")
    @ResponseBody
    public ApiResult<StudentDO> pushMessage(@RequestBody StudentDO studentDO, ServletRequest request) {
        ApiResult<StudentDO> result = new ApiResult<>();
        try{
            HttpServletRequest httpServletRequest = (HttpServletRequest)request;
            String value = (String) httpServletRequest.getAttribute("key");
            String valueName = (String) httpServletRequest.getAttribute("paramName");
            result.setErrMsg(value);
            result.setErrCode(valueName);
            result.setModel(studentDO);
        } catch (Exception e){
            result.setSuccess(false);
            result.setErrCode("system.error");
            result.setErrMsg("系统错误");
        }
        return result;
    }

    @RequestMapping("html2")
    public void ttt(HttpServletResponse response){
        try {
//            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();

            StringBuilder sb = new StringBuilder();
            sb.append("<html><body><h1>hello World!</h1></body></html>");
            writer.print(sb.toString());
//            writer.print("<html>");
//            writer.print("<body>");
//            writer.print("<h1>hello World!</h1>");
//            writer.print("</body>");
//            writer.print("</html>");
            //wode ceshi

        } catch(Exception e){

        }
    }

}
