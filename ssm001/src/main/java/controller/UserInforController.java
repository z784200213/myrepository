package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userinfor")
public class UserInforController {
    @GetMapping("/index")
    public  String index(){
        return  "123";
    }
}
