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
    private final TokenDecoder tokenDecoder;

    public JwtRequestInterceptor(TokenDecoder tokenDecoder) {
        this.tokenDecoder = tokenDecoder;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("prehandling request");
        String token = tokenDecoder.resolveToken(request);

        try {
            tokenDecoder.checkToken(token);
        } catch (Exception e){
            logger.error(e);
        }

        if (tokenDecoder.isJwtTokenValid(token)) {
            Long userId = tokenDecoder.decodeToken(token);
            logger.info("Dotarłem tu. ID usera: " + userId);
            return true;
        } else {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Token expires");
            logger.error("JWT Token expires.");
            return false;
        }
    }

}
