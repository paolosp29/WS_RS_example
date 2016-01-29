package pe.com.strategies.dao.db.mapper;

import java.util.Map;

public interface CursoMapper {
	Map<String, Object> getPassword(Map<String, Object> map) throws Exception;
	Map<String, Object> getStatusLogeo(Map<String, Object> map) throws Exception;
}
