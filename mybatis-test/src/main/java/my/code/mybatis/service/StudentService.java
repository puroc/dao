package my.code.mybatis.service;

import java.util.List;

import my.code.mybatis.auto.generate.mapper.StudentMapper;
import my.code.mybatis.auto.generate.model.Student;
import my.code.mybatis.auto.generate.model.StudentExample;
import my.code.mybatis.auto.generate.model.StudentExample.Criteria;
import my.code.mybatis.exception.DbException;

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
		student.setAge("34");
		student.setName(name);
		studentMapper.insert(student);
		// throw new DbException("insert failed.");
	}

	public List<Student> selectByName(String name) throws DbException {
		StudentExample example = new StudentExample();
		example.createCriteria().andNameEqualTo(name);
		return studentMapper.selectByExample(example);
	}

	public Student selectById(Integer id) {
		return studentMapper.selectByPrimaryKey(id);
	}

}
