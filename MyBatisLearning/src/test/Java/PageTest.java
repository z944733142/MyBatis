import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageTest {
    public static void main(String[] args) throws IOException {
        int pageNum = 3;
        int pageSize = 3;
        InputStream inputStream = Resources.getResourceAsStream("Mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Map map = new HashMap();
        map.put("pageNum", (pageNum - 1) * pageSize);
        map.put("pageSize", pageSize);
        List list = sqlSession.selectList("selMap", map);
        System.out.println(list);
        // 别名

    }
}
