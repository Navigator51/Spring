package su.goodcat.spring.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class
SuccessLoginHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request, HttpServletResponse response, Authentication authentication
    ) throws IOException {
        Set<String> rolesSet = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (rolesSet.contains("ROLE_ADNIN")) {
            response.sendRedirect("/admin");
        } else if (rolesSet.contains("ROLE_USER")) {
            response.sendRedirect("/main");
        } else if (rolesSet.contains("ROLE_SUPER_MEGA_GALAXY_ADMIN")) {
            response.sendRedirect("/configuration");
        } else {
            response.sendRedirect("/login");
        }
    }
}
