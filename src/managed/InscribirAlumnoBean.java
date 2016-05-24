package managed;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.RequestScoped;

import ejbs.GestionAlumnosLocal;
import ejbs.GestionCursosLocal;
import ejbs.GestionMatriculasLocal;
import entidades.Alumno;
import entidades.Curso;
import entidades.Matricula;


@ManagedBean(name="inscribirAlumnoBean")
@RequestScoped
public class InscribirAlumnoBean {
	@EJB
	GestionAlumnosLocal galumno;
	@EJB
	GestionCursosLocal gcursos;
	@EJB
	GestionMatriculasLocal gmatricula;
	
	private List<Matricula> listaMatriculas;
	private List<Alumno> listaAlumnos;
	private List<Curso> listaCursos;
	private Alumno al;
	private Curso cur;
	private int idAlumno;
	private int idCurso;
	

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public List<Matricula> getListaMatriculas() {
		return listaMatriculas;
	}

	public void setListaMatriculas(List<Matricula> listaMatriculas) {
		this.listaMatriculas = listaMatriculas;
	}

	public Alumno getAl() {
		return al;
	}

	public void setAl(Alumno al) {
		this.al = al;
	}

	public Curso getCur() {
		return cur;
	}

	public void setCur(Curso cur) {
		this.cur = cur;
	}

	public List<Alumno> getListaAlumnos() {
		listaAlumnos = galumno.consultarAlumnos();
		listaCursos = gcursos.consultarCursos();
		return listaAlumnos;
	}

	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}

	public InscribirAlumnoBean() {

	}
	public void seleccionarAlumno(){
		al=galumno.consultarAlumnosPorId(idAlumno);
		listaMatriculas = al.getMatriculas();
	}
	public void seleccionarCurso(){
		cur = gcursos.consultarCursoPorId(idCurso);
		
	}
	public String registrar(){

		if ((idAlumno != 0) && (idCurso != 0)){
			
			gmatricula.registrarMatricula(idCurso, idAlumno);
		
			return "inicio";
		}
		return "";
		
	}
	
	
}
