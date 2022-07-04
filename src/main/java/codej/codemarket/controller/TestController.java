package codej.codemarket.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @GetMapping("/message")
    @ResponseBody
    public String testByResponseBody(){
        String message = "안녕하세용";

        return message;

    }
    @GetMapping("/members")
    @ResponseBody
    public Map<Integer,Object> testByResponseBody1(){

        Map<Integer, Object> members = new HashMap<>();

        for(int i=0; i <= 20; i++) {
            Map<String, Object> member = new HashMap <>();
            member.put("idx",i);
            member.put("nickname",i+"code");
            member.put("height",i+20);
            member.put("weight",i+30);
            members.put(i,member);

    }
        return members;
    }
}
