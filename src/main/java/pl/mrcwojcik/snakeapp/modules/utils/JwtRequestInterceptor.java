package pl.mrcwojcik.snakeapp.modules.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtRequestInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LogManager.getLogger(JwtRequestInterceptor.class);


}
