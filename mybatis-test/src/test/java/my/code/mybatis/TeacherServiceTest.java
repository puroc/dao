/**
 * 
 */
package my.code.mybatis;

import java.util.List;

import my.code.mybatis.auto.generate.model.Student;
import my.code.mybatis.auto.generate.model.Teacher;
import my.code.mybatis.exception.DbException;
import my.code.mybatis.service.TeacherService;

import org.junit.Assert;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByName;

/**
 * @author pud
 * 
 */
@SpringApplicationContext("spring-beans.xml")
public class TeacherServiceTest extends UnitilsJUnit4 {

	@SpringBeanByName
	private TeacherService teacherService;

	@Test
	public void testInsert() {
		try {
			Teacher teacher = new Teacher();
			teacher.setLocation("于洪区");
			teacher.setName("汪老师");
			teacher.setSex("男");
			teacherService.insert(teacher);
		} catch (DbException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testSelectByName() {
		List<Teacher> list;
		try {
			list = teacherService.selectByName("汪老师");
			Assert.assertTrue(list.size() == 1);
		} catch (DbException e) {
			Assert.fail(e.getMessage());
		}
	}
}
