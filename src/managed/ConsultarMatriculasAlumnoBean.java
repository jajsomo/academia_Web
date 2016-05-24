package managed;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.RequestScoped;

import ejbs.GestionAlumnosLocal;
import ejbs.GestionMatriculasLocal;
import entidades.Alumno;
import entidades.Matricula;


@ManagedBean(name="consultarMatriculasAlumnoBean")
@RequestScoped
public class ConsultarMatriculasAlumnoBean {
	@EJB
	GestionAlumnosLocal galumno;
	@EJB
	GestionMatriculasLocal gmatricula;
	
	private List<Alumno> listaAlumnos;
	private List<Matricula> listaMatriculas;
	private Alumno al;
	private int idAlumno;

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Alumno getAl() {
		return al;
	}

	public void setAl(Alumno al) {
		this.al = al;
	}

	public List<Alumno> getListaAlumnos() {
		listaAlumnos = galumno.consultarAlumnos();
		return listaAlumnos;
	}

	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}


	public List<Matricula> getListaMatriculas() {
		return listaMatriculas;
	}

	public void setListaMatriculas(List<Matricula> listaMatriculas) {
		this.listaMatriculas = listaMatriculas;
	}

	public ConsultarMatriculasAlumnoBean() {
		listaMatriculas =new ArrayList<>();
	}
	public void seleccionarAlumno(){
		listaMatriculas = gmatricula.consultarMatriculaPorAlumno(idAlumno);

	}
	
}
