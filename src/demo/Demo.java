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
		//��ȡ�����ļ�
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//����SqlSessionFactory����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//����SqlSession����
		SqlSession session = factory.openSession(true);
		
		//����sql
//		//ȫ��
//		List<Student> selall = session.selectList("JJ.selectAll");
//		System.out.println(selall);
//		
//		//��ĳ��
//		Student selone = session.selectOne("JJ.selectOne", "95003");
//		System.out.println(selone);
//		
//		//����
//		Student shanshan = new Student(100, "yuanshanshan", "Ů", 30, "Code");
//		int row = session.insert("JJ.insertOne", shanshan);
//		System.out.println(row);
//		
//		//ɾ��
//		int row = session.delete("JJ.deleteOne", 100);
//		System.out.println(row);
		
		StuMapper mapper = session.getMapper(mapper.StuMapper.class);
		List<Student> selectAll = mapper.selectAll();
		System.out.println(selectAll);
		
		Student selectOne = mapper.selectOne("�����");
		System.out.println(selectOne);
		
//		Student shanshan = new Student(100, "yuanshanshan", "Ů", 30, "Code");
//		int row = mapper.insertOne(shanshan);
//		System.out.println(row);
		
//		int row = mapper.deleteOne(100);
//		System.out.println(row);
		
//		Student selectLike = mapper.selectLike("��");
//		System.out.println(selectLike);
//		
//		List<Student> selectIf = mapper.selectIf("�����");
//		System.out.println(selectIf);
//		
//		List<Student> selectChoose = mapper.selectChoose("��", 18, 19);
//		System.out.println(selectChoose);
		
//		List<Student> selectWhen = mapper.selectWhen("Ů", "MA");
//		System.out.println(selectWhen);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(17);
		list.add(18);
		List<Student> selectIn = mapper.selectIn(list);
		System.out.println(selectIn);
		
		session.close();
		
	}
	
}

