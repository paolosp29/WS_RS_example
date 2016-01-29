package pe.com.strategies.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlSessionFactory {
	private static SqlSessionFactory FACTORY = null;

	// Private constructor suppresses
	private MyBatisSqlSessionFactory() {
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		if (FACTORY == null) {
			String resource = "mybatis-config.xml";
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			FACTORY = new SqlSessionFactoryBuilder().build(inputStream);
		}
		return FACTORY;
	}

}
