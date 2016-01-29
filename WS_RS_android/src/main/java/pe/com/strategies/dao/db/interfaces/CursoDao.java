package pe.com.strategies.dao.db.interfaces;

import pe.com.strategies.bean.Curso;

public interface CursoDao {

	Curso getPassword(String codigo) throws Exception;
	Curso getStatusLogeo(String codigo, String pass) throws Exception;

}
