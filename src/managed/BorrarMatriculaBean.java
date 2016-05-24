package managed;



import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import ejbs.GestionCursosLocal;
import ejbs.GestionMatriculasLocal;
import entidades.Curso;
import entidades.Matricula;



@ManagedBean(name="borrarMatriculaBean")
@RequestScoped
public class BorrarMatriculaBean {
	@EJB
	GestionCursosLocal gcurso;
	@EJB
	GestionMatriculasLocal gmatricula;	
	
	@ManagedProperty("#{loginBean}")

	private LoginBean login;

	private List<Matricula> listaMatriculas;



	public LoginBean getLogin() {
		return login;
	}



	public void setLogin(LoginBean login) {
		this.login = login;
	}



	public List<Matricula> getListaMatriculas() {
		listaMatriculas=gmatricula.consultarMatriculaPorDni(login.getUsuario());
		return listaMatriculas;
	}



	public void setListaMatriculas(List<Matricula> listaMatriculas) {
		this.listaMatriculas = listaMatriculas;
	}



	public String borrarMatricula(Matricula matricula){
		gmatricula.eliminarMatriculaPorId(matricula.getIdMatriculas());
		return "alumno";
	}
	
}
