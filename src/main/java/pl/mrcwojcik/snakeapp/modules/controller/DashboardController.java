package pl.mrcwojcik.snakeapp.modules.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import pl.mrcwojcik.snakeapp.modules.utils.TokenDecoder;

@RestController
public class DashboardController {

    private final TokenDecoder tokenDecoder;

    public DashboardController(TokenDecoder tokenDecoder) {
        this.tokenDecoder = tokenDecoder;
    }

    @GetMapping("/dashboard")
    public String showDashboard(@RequestHeader("Authorization") String token){
        System.out.println(tokenDecoder.decodeToken(token));
        return "Dashboard";
    }

}
