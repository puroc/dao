/**
 * 
 */
package my.code.mybatis;

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
public class StudentServiceTest extends UnitilsJUnit4{

	@SpringBeanByName
	private StudentService studentService;
	
	@Test
	public void testInsert(){
		try {
			studentService.insert("haha");
		} catch (DbException e) {
			Assert.fail(e.getMessage());
		}
	}
}
