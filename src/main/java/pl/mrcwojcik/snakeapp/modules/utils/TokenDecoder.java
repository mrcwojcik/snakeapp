package pl.mrcwojcik.snakeapp.modules.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Component
public class TokenDecoder {

    private final String secret;
    private static final String TOKEN_PREFIX = "Bearer ";
    private static Logger logger = LogManager.getLogger(TokenDecoder.class);

    public TokenDecoder(@Value("${jwt.secret}") String secret) {
        this.secret = secret;
    }

    public Long decodeToken(String token){
        if (checkToken(token)) {
            return JWT.require(Algorithm.HMAC256(secret))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .getClaim("id")
                    .asLong();
        }

        throw new JWTVerificationException("Token nieprawidłowy.");
    }

    public boolean checkToken(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            return true;
        }

        throw new JWTVerificationException("Token nieprawidłowy.");
    }

    public boolean isJwtTokenValid(String token) {
        Date currentDate = new Date(System.currentTimeMillis());
        Date expirationDate = JWT.require(Algorithm.HMAC256(secret))
                .build()
                .verify(token.replace(TOKEN_PREFIX, ""))
                .getExpiresAt();
        if (expirationDate.after(currentDate)){
            return true;
        }

        return false;
    }

    public String resolveToken(HttpServletRequest req) {
        return req.getHeader("Authorization");
    }

}
