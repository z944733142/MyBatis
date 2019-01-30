import com.pojo.Flower;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryTest {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("MyBatis.xml");
        //工厂设计模式
        SqlSessionFactory  factory = new SqlSessionFactoryBuilder().build(is);
        //生产SqlSession
        SqlSession session = factory.openSession();
        //查询list
        List<Flower> list = session.selectList("com.mapper.selAll");
        for (Flower flower : list) {
            System.out.println(flower.getAddress() + " " + flower.getId() + " " + flower.getName());
        }
        //查询单个数据 one
        System.out.println("数量" + session.selectOne("com.mapper.selCount"));
        // 查询map
        Map map = session.selectMap("com.mapper.selAll", "id");
        System.out.println(map);
        // 查询byID
        // #{0} 或 #{param1} 一个参数#{随便填}调用sql语句  使用PreparedStatement 和?占位符
        session.selectOne("com.mapper.selById", 2);
        // 使用 ${属性} 调用对象的get方法获取对象属性.
        Flower flower = new Flower();
        flower.setId(2);
        session.selectOne("com.mapper.selById2", flower);
        // 使用map #{key}获取值
        Map map1 = new HashMap();
        map1.put("id", 2);
        session.selectOne("com.mapper.selById3", map1);
    }
}
