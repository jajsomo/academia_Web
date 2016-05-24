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


@ManagedBean(name="alumnoMatricularBean")
@RequestScoped
public class AlumnoMatricularBean {
	@EJB
	GestionAlumnosLocal galumno;
	@EJB
	GestionMatriculasLocal gmatricula;
	@EJB
	GestionCursosLocal gcursos;
	
	@ManagedProperty("#{loginBean}")
	private LoginBean login;

	private List<Matricula> listaMatriculas;
	private Alumno al;
	private Curso cur;
	private List<Curso> listaCursos;
	
	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	
	public Curso getCur() {
		return cur;
	}

	public void setCur(Curso cur) {
		this.cur = cur;
	}

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}

	public List<Matricula> getListaMatriculas() {
		return listaMatriculas;
	}

	public void setListaMatriculas(List<Matricula> listaMatriculas) {
		this.listaMatriculas = listaMatriculas;
	}
	public Alumno getAl() {
		al= galumno.consultarAlumnosPorDni(login.getUsuario());
		int idAl = al.getIdAlumno();
		listaMatriculas = gmatricula.consultarMatriculaPorAlumno(idAl);
		listaCursos = gcursos.consultarCursos();
		for(Matricula m: listaMatriculas){
			for(Curso c:listaCursos){
				if(m.getCurso().getIdCurso() == c.getIdCurso()){
					listaCursos.remove(c);
					break;
				}
				
			}
		}

		return al;
	}

	public void setAl(Alumno al) {
		this.al = al;
	}
	
	public void inscribirMatricula(Curso cur){
		//System.out.println("curso "+ cur.getIdCurso());
		//gmatricula.registrarMatricula( cur.getIdCurso(), al.getIdAlumno());
		gmatricula.registrarMatricula(11,4);
		listaMatriculas = gmatricula.consultarMatriculas();
		System.out.println("curso "+ cur.getIdCurso());

		System.out.println(listaMatriculas.size());
		Curso c= gcursos.consultarCursoPorId( cur.getIdCurso());
		listaCursos.remove(c);
		
	}
	
	
}
