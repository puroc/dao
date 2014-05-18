package my.code.mybatis.service;

import java.util.List;

import my.code.mybatis.auto.generate.mapper.TeacherMapper;
import my.code.mybatis.auto.generate.model.Student;
import my.code.mybatis.auto.generate.model.Teacher;
import my.code.mybatis.auto.generate.model.TeacherExample;
import my.code.mybatis.exception.DbException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;

	@Transactional(rollbackFor = DbException.class)
	public void insert(Teacher teacher) throws DbException {
		teacherMapper.insert(teacher);
	}

	public List<Teacher> selectByName(String name) throws DbException {
		TeacherExample example = new TeacherExample();
		example.createCriteria().andNameEqualTo(name);
		return teacherMapper.selectByExample(example);
	}

}
