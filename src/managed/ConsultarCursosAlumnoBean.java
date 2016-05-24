package managed;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import ejbs.GestionAlumnosLocal;
import ejbs.GestionMatriculasLocal;
import entidades.Alumno;
import entidades.Matricula;


@ManagedBean(name="consultarCursosAlumnoBean")
@RequestScoped
public class ConsultarCursosAlumnoBean {
	@EJB
	GestionAlumnosLocal galumno;
	@EJB
	GestionMatriculasLocal gmatricula;
	
	@ManagedProperty("#{loginBean}")
	private LoginBean login;

	private List<Matricula> listaMatriculas;
	private Alumno al;

	
	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public Alumno getAl() {
		al= galumno.consultarAlumnosPorDni(login.getUsuario());
		listaMatriculas = gmatricula.consultarMatriculaPorDni(al.getDni());
		return al;
	}

	public void setAl(Alumno al) {
		this.al = al;
	}


	public List<Matricula> getListaMatriculas() {
		return listaMatriculas;
	}

	public void setListaMatriculas(List<Matricula> listaMatriculas) {
		this.listaMatriculas = listaMatriculas;
	}

	public ConsultarCursosAlumnoBean() {

	}
	
}
