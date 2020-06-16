package demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import entity.Role;
import entity.User;
import mapper.RoleMapper;
import mapper.UserMapper;

public class MapDemo {
	public static void main(String[] args) {
		InputStream input = null;
		
		try {
			input = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
		SqlSession session = factory.openSession(true);
		
		UserMapper usermapper = session.getMapper(UserMapper.class);
		List<User> users = usermapper.queryAll();
		System.out.println(users);
		
		RoleMapper rolemapper = session.getMapper(RoleMapper.class);
		List<Role> roles = rolemapper.queryAll();
		System.out.println(roles);
	}
}
