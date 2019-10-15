import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author : Hens
 * @date : 2019/9/13 11:18
 */
public class Encoding {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("secret"));
    }
}
