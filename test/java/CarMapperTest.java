import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarMapperTest {

    @Test
    //使用pojo类
    public void testCarPojo(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarPojo carPojo = new CarPojo(null,"2222","奔驰AMG",10.0,"2019-11-2","燃油车");
        //执行sql
        int count = sqlSession.insert("insertCar",carPojo);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    //使用map集合
    public void testInserCar() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //模拟前端传来的数据，用map集合封装
        //对象传入map集合
        Map<String,Object> map= new HashMap<>();
        map.put("car_num","1111");
        map.put("brand","奥迪RS7");
        map.put("guide_price",10.0);
        map.put("produce_time","2020-12-11");
        map.put("car_type","燃油车");
        //执行sql
        int count = sqlSession.insert("insertCar",map);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    //删
    public void testDeleteCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.delete("deleteCar",15);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    //改
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarPojo carPojo = new CarPojo(11L,"5613","文哥好猛",99.9,"2000-01-28","燃油车");
        int count = sqlSession.update("updateCar",carPojo);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    //查一个
    public void testSelect01(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Object count = sqlSession.selectOne("selectCar01",11);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelect02(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Object> count = sqlSession.selectList("selectCar02");
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }
}
