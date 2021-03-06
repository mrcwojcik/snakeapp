package pl.mrcwojcik.snakeapp.authorization;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import pl.mrcwojcik.snakeapp.modules.user.User;
import pl.mrcwojcik.snakeapp.modules.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final long expirationTime;
    private final String secret;
    private final UserService userService;

    public RestAuthenticationSuccessHandler(@Value("${jwt.expirationTime}") long expirationTime,
                                            @Value("${jwt.secret}") String secret, UserService userService) {
        this.expirationTime = expirationTime;
        this.secret = secret;
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        UserDetails principal = (UserDetails) authentication.getPrincipal();
        User user = userService.findUserByEmail(principal.getUsername());
        System.out.println(user.getId());

        String token = JWT.create()
                .withSubject(principal.getUsername())
                .withClaim("id", user.getId())
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
                .sign(Algorithm.HMAC256(secret));
        response.addHeader("Authorization", "Bearer " + token);

    }
}
