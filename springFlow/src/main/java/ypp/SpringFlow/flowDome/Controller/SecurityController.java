package ypp.SpringFlow.flowDome.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SecurityController {
    @PostMapping("/spittr/login")
    public String securityTest01(@RequestParam Map<String,String> map){
        return "spizzaOrder.do";
    }
}
