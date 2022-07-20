import com.itheima.mapper.UserMapper;
import com.itheima.poij.User;
import com.itheima.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class testFunction {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Test
    public void test1() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User loginUser = mapper.login(new User("张三", "123456"));
        if (loginUser != null) {
            System.out.println("登录成功");
            System.out.println(loginUser);
        } else {
            System.out.println("登录失败");
        }
    }

    @Test
    public void test2() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User userTemp = mapper.selectByName("李四");
        System.out.println(userTemp);
    }

    @Test
    public void test3() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.addUser(new User(null, "l奥利给hl","123456"));
        sqlSession.close();

    }
}
