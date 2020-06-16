package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Student;

public interface StuMapper {
	
	public List<Student> selectAll();
	
	public Student selectOne(String name);
	
	public int insertOne(Student student);
	
	public int deleteOne(int id);
	
	public Student selectLike(String name);
	
	public List<Student> selectIf(@Param("name")String name);
	
	public List<Student> selectChoose(@Param("sex")String sex, @Param("lower")int lower, @Param("higher")int higher);
	
	public List<Student> selectWhen(@Param("sex")String sex, @Param("department")String department);
	
	public List<Student> selectIn(List<Integer> list);
}
