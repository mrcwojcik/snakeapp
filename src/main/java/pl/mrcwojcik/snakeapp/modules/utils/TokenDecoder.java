package pl.mrcwojcik.snakeapp.modules.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenDecoder {

    private final String secret;
    private static final String TOKEN_PREFIX = "Bearer ";

    public TokenDecoder(@Value("${jwt.secret}") String secret) {
        this.secret = secret;
    }

    public long decodeToken(String token){
        return JWT.require(Algorithm.HMAC256(secret))
                .build()
                .verify(token.replace(TOKEN_PREFIX, ""))
                .getClaim("id")
                .asLong();
    }

}
