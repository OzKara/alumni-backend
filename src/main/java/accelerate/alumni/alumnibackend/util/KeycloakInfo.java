package accelerate.alumni.alumnibackend.util;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class KeycloakInfo {
    public Map<String, String> getUserInfo(Jwt principal) {
        Map<String, String> userInfoMap = new HashMap<>();
        userInfoMap.put("subject", principal.getClaimAsString("sub"));
        userInfoMap.put("user_name", principal.getClaimAsString("preferred_username"));
        userInfoMap.put("email", principal.getClaimAsString("email"));
        userInfoMap.put("first_name", principal.getClaimAsString("given_name"));
        userInfoMap.put("last_name", principal.getClaimAsString("family_name"));
        userInfoMap.put("roles", String.valueOf(principal.getClaimAsStringList("roles")));
        return userInfoMap;
    }
}
