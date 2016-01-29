package pe.com.strategies.dao.db.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import pe.com.strategies.bean.Curso;
import pe.com.strategies.dao.db.interfaces.CursoDao;
import pe.com.strategies.dao.db.mapper.CursoMapper;
import pe.com.strategies.util.MyBatisSqlSessionFactory;

public class CursoDaoImpl implements CursoDao {

	public Curso getPassword(String codigo) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        String pass="";
        Curso curso;
		SqlSession sqlSession= MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();
        System.out.println("codigo :: " + codigo);
        map.put("codigo", codigo);
        map.put("clave", pass);
		try {
			CursoMapper simpleByPhoneMapper =sqlSession.getMapper(CursoMapper.class);
			System.out.println("[CursoDaoImpl][getPassword] Datos de consulta dnNum : " + codigo);
			map=simpleByPhoneMapper.getPassword(map);
            System.out.println("[CursoDaoImpl][getPassword] Datos de resultado map : " + map);
            String msj = (String)map.get("errorMsg");
            if (msj != null) {
                throw new SQLException("Error getPassword : " + msj);
            }
            pass=(String)map.get("CLAVE");
            curso= new Curso();
            curso.setPassword(pass);
            System.out.println("[CursoDaoImpl][getPassword] pass : " + pass);
		} catch (Exception e) {
			System.out.println("[CursoDaoImpl][getPassword] Error : " + e);
            throw new Exception("Error CursoDaoImpl : " + e, e);
		}finally {
			sqlSession.close();
		}
		return curso;
	}

	public Curso getStatusLogeo(String codigo, String pass) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        String status="";
        Curso curso;
		SqlSession sqlSession= MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();
        System.out.println("codigo :: " + codigo);
        map.put("codigo", codigo);
        map.put("pass", pass);
        map.put("STATUS", "");
		try {
			CursoMapper simpleByPhoneMapper =sqlSession.getMapper(CursoMapper.class);
			System.out.println("[CursoDaoImpl][getStatusLogeo] Datos de consulta dnNum : " + codigo);
			simpleByPhoneMapper.getStatusLogeo(map);
            System.out.println("[CursoDaoImpl][getStatusLogeo] Datos de resultado map : " + map);
            String msj = (String)map.get("errorMsg");
            if (msj != null) {
                throw new SQLException("Error getPassword : " + msj);
            }
            status=(String)map.get("STATUS");
            curso= new Curso();
            curso.setStatus(status);
            System.out.println("[CursoDaoImpl][getStatusLogeo] status : " + status);
		} catch (Exception e) {
			System.out.println("[CursoDaoImpl][getStatusLogeo] Error : " + e);
            throw new Exception("Error CursoDaoImpl : " + e, e);
		}finally {
			sqlSession.close();
		}
		return curso;
	}
}