package pharmacy.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCrypt {
    public static String bcrypt(final String password) {
        return password == null ? null : new BCryptPasswordEncoder().encode(password);
    }
}
