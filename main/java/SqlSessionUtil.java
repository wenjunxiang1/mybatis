//mybatis工具类
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;

public class SqlSessionUtil {
    //工具类构造方法,私有化防止new对象
    private SqlSessionUtil() {
    }

    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
}
