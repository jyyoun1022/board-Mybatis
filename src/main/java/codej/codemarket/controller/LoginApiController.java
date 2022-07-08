package codej.codemarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginApiController {

    @GetMapping("/api/v1/login")
    public String login(){
         return  "Success ADMIN";
    }
    @GetMapping("/api/v1/login2")
    public String login2(){
        return "Success MANER";
    }
}
