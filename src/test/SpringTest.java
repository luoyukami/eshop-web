import com.app.bean.User;
import com.app.dao.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    private static ApplicationContext ctx;
    private static UserDAO userDAO;

    static {
        ctx = new ClassPathXmlApplicationContext(
                new String[]{"spring-config.xml"}
        );
        userDAO = (UserDAO) ctx.getBean("userDAO");
    }

    public static void main(String[] args) {

        User user = userDAO.getById(1);
        System.out.print(user.toString());
    }
}
