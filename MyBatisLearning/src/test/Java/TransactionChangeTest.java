import com.pojo.Flower;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TransactionChangeTest {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("MyBatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Flower flower = new Flower();
        flower.setName("flw");
        flower.setAddress("here");
        int i = sqlSession.insert("insFlower", flower);
        System.out.println(i);
        flower.setAddress("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        try {
            sqlSession.insert("insFlower", flower);
        }catch (Exception e)
        {
            sqlSession.rollback();
        }
        sqlSession.commit();
    }
}
