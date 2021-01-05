package pl.mrcwojcik.snakeapp.modules.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public @ResponseBody  String sayHello(){
        return "Hello world";
    }

}
