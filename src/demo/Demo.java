package demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import entity.Student;
import mapper.StuMapper;

public class Demo {
	public static void main(String[] args) {
		//读取配置文件
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//创建SqlSessionFactory对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//创建SqlSession对象
		SqlSession session = factory.openSession(true);
		
		//发送sql
//		//全查
//		List<Student> selall = session.selectList("JJ.selectAll");
//		System.out.println(selall);
//		
//		//查某个
//		Student selone = session.selectOne("JJ.selectOne", "95003");
//		System.out.println(selone);
//		
//		//插入
//		Student shanshan = new Student(100, "yuanshanshan", "女", 30, "Code");
//		int row = session.insert("JJ.insertOne", shanshan);
//		System.out.println(row);
//		
//		//删除
//		int row = session.delete("JJ.deleteOne", 100);
//		System.out.println(row);
		
		StuMapper mapper = session.getMapper(mapper.StuMapper.class);
		List<Student> selectAll = mapper.selectAll();
		System.out.println(selectAll);
		
		Student selectOne = mapper.selectOne("王风娟");
		System.out.println(selectOne);
		
//		Student shanshan = new Student(100, "yuanshanshan", "女", 30, "Code");
//		int row = mapper.insertOne(shanshan);
//		System.out.println(row);
		
//		int row = mapper.deleteOne(100);
//		System.out.println(row);
		
//		Student selectLike = mapper.selectLike("玲");
//		System.out.println(selectLike);
//		
//		List<Student> selectIf = mapper.selectIf("王风娟");
//		System.out.println(selectIf);
//		
//		List<Student> selectChoose = mapper.selectChoose("男", 18, 19);
//		System.out.println(selectChoose);
		
//		List<Student> selectWhen = mapper.selectWhen("女", "MA");
//		System.out.println(selectWhen);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(17);
		list.add(18);
		List<Student> selectIn = mapper.selectIn(list);
		System.out.println(selectIn);
		
		session.close();
		
	}
	
}

