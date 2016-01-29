package pe.com.strategies.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pe.com.strategies.bean.Curso;
import pe.com.strategies.dao.db.impl.CursoDaoImpl;
import pe.com.strategies.dao.db.interfaces.CursoDao;
@Path("/CursoService")
public class CursoService {

	@GET
	@Path("getClave")
	@Produces({MediaType.APPLICATION_JSON })
	public Response getPassword(@QueryParam("codigo") String codigo) {
		String pass = "";
		Curso curso=new Curso();
		System.out.println("[CursoService][getPassword] Input request :" + codigo);
		try {
			CursoDao cursoDao = new CursoDaoImpl();
			curso = cursoDao.getPassword(codigo);

		} catch (Exception ex) {
			System.out.println("[GetSimpleByPhoneBO][getSimpleByPhone] Error ex : " + ex);
			ex.printStackTrace();
		} catch (Throwable t) {
			System.out.println("[GetSimpleByPhoneBO][getSimpleByPhone] Error t : " + t);
			t.printStackTrace();
		} finally {
		}
		return Response.ok(curso).build();
	}
	
	@GET
	@Path("getHola")
	@Produces({MediaType.APPLICATION_JSON })
	public Response getStatus(@QueryParam("codigo") String codigo, @QueryParam("pass") String pass){
		Curso curso=new Curso();
		System.out.println("[CursoService][getStatus] Input request :" + codigo);
		System.out.println("[CursoService][getStatus] Input pass :" + pass);
		try {
			CursoDao cursoDao = new CursoDaoImpl();
			curso = cursoDao.getStatusLogeo(codigo, pass);

		} catch (Exception ex) {
			System.out.println("[GetSimpleByPhoneBO][getStatus] Error ex : " + ex);
			ex.printStackTrace();
		} catch (Throwable t) {
			System.out.println("[GetSimpleByPhoneBO][getStatus] Error t : " + t);
			t.printStackTrace();
		} finally {
		}
		return Response.ok(curso).build();
	}
}
