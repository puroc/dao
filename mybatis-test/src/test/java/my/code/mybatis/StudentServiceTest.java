/**
 * 
 */
package my.code.mybatis;

import java.util.List;

import my.code.mybatis.auto.generate.model.Student;
import my.code.mybatis.exception.DbException;
import my.code.mybatis.service.StudentService;

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
public class StudentServiceTest extends UnitilsJUnit4 {

	@SpringBeanByName
	private StudentService studentService;

	// @Test
	public void testInsert() {
		try {
			studentService.insert("xixi");
		} catch (DbException e) {
			Assert.fail(e.getMessage());
		}
	}

	// @Test
	public void testSelectById() {
		Student student = studentService.selectById(1);
		Assert.assertTrue(student.getName().equals("haha"));
	}

	@Test
	public void testSelectByName() {
		List<Student> list;
		try {
			list = studentService.selectByName("xixi");
			Assert.assertTrue(list.size() == 2);
		} catch (DbException e) {
			Assert.fail(e.getMessage());
		}
	}
}
