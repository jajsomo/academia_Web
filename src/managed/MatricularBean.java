package managed;



import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import ejbs.GestionAlumnosLocal;
import ejbs.GestionCursosLocal;
import ejbs.GestionMatriculasLocal;
import entidades.Alumno;
import entidades.Curso;
import entidades.Matricula;



@ManagedBean(name="matricularBean")
@RequestScoped
public class MatricularBean {
	@EJB
	GestionCursosLocal gcursos;
	@EJB
	GestionAlumnosLocal galumnos;
	@EJB
	GestionMatriculasLocal gmatricula;
	
	
	@ManagedProperty("#{loginBean}")
	private LoginBean login;
	private Alumno al;
	private List<Matricula> matriculas;
	private Curso curso;
	private List<Curso> cursos;

	
	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public Alumno getAl() {
		al=galumnos.consultarAlumnosPorDni(login.getUsuario());
		matriculas = gmatricula.consultarMatriculaPorAlumno(al.getIdAlumno());
		cursos = gcursos.consultarCursos();
		for(Matricula m: matriculas){
			for(Curso c:cursos){
				if(m.getCurso().getIdCurso() == c.getIdCurso()){
					cursos.remove(c);
					break;
				}
				
			}
		}
		return al;
	}

	public void setAl(Alumno al) {
		this.al = al;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void borrarCurso(Curso curso){
		System.out.println("Entrada");
		curso.setPlazasLibres(curso.getPlazas()-1);/*
		gcurso.eliminarCurso(curso.getIdCurso());*/
	}
	
}
