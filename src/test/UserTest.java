import com.app.bean.User;
import com.app.service.UserBaseService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UserTest {

    private static UserBaseService userBaseService = new UserBaseService();

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory;
        UserTest userTest = new UserTest();

        sqlSessionFactory = userTest.getSqlSessionFactory();
        if(null != sqlSessionFactory){
            SqlSession sqlSession = sqlSessionFactory.openSession();
            User user = sqlSession.selectOne("User.getById", 1);
            System.out.print(user.toString());
            sqlSession.close();
        }
    }

    private SqlSessionFactory getSqlSessionFactory(){
        String resourse = "mybatis-config.xml";
        InputStream inputStream;
        SqlSessionFactory sqlSessionFactory;
        try {
            inputStream = Resources.getResourceAsStream(resourse);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            return sqlSessionFactory;
        } catch (IOException e) {
            System.out.print("mybatis配置文件加载异常");
            e.printStackTrace();
        }
        return null;
    }
}

