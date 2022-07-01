package codej.codemarket.util;

import codej.codemarket.constant.Method;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UiUtils {

    public String showMessageWithRedirect(@RequestParam(value = "message",required = false) String message,
                                          @RequestParam(value = "redirectUri",required = false)String redirectUri,
                                          @RequestParam(value = "method",required = false)Method method,
                                          @RequestParam(value = "params",required = false) Map<String,String> params, Model model){
        model.addAttribute("message",message);
        model.addAttribute("redirectUri",redirectUri);
        model.addAttribute("method",message);
        model.addAttribute("params",params);

        return "utils/message-redirect";

    }
}