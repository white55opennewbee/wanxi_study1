package example.pc.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class Mybatis_Utils {
    private static String resource = "Mybatis.xml";
    private static SqlSessionFactory factory;
    private static SqlSession sqlSession;
    //初始化sqlsessionFactory
    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取sqlsession实例
    public static SqlSession getSqlsession(){
        if (sqlSession==null){
            sqlSession = factory.openSession(true);
        }
        return sqlSession;
    }



}
