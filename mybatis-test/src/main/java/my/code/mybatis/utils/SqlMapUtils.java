package my.code.mybatis.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * ֱ��ʹ��mybatis��ʱ����Ҫ�õ�����࣬��mybatis��spring���ɵ�ʱ����Ҫ�����
 * @author pud
 *
 */
public class SqlMapUtils {
//	private static final Logger logger = LogManager
//			.getLogger(SqlMapUtils.class);

	private static final String CONFIG_FILE_PATH = "mybatis-config.xml";

	private SqlSessionFactory sessionFactory = null;

	private static SqlMapUtils instance = null;

	public SqlMapUtils() {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(CONFIG_FILE_PATH);
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static synchronized SqlMapUtils getInstance() {
		if (instance == null) {
			synchronized (SqlMapUtils.class) {
				instance = new SqlMapUtils();
			}
		}
		return instance;
	}

	public SqlSession getSession() {
		return sessionFactory.openSession();
	}

}
