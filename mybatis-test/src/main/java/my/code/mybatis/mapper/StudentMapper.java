package my.code.mybatis.mapper;

import java.util.List;

import my.code.mybatis.domain.Student;

public interface StudentMapper {

	List<Student> select(String name);

	void insert(Student student);

}
