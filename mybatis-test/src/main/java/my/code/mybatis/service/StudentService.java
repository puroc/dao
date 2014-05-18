package my.code.mybatis.service;

import java.util.List;

import my.code.mybatis.domain.Student;
import my.code.mybatis.mapper.StudentMapper;
import my.code.mybatis.exception.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

	@Autowired
	private StudentMapper studentMapper;

	@Transactional(rollbackFor = DbException.class)
	public void insert(String name) throws DbException {
		Student student = new Student();
		student.setAge(34);
		student.setName(name);
		studentMapper.insert(student);
//		throw new DbException("insert failed.");
	}

	public List<Student> select(String name) throws DbException {
		return studentMapper.select(name);
	}

}
