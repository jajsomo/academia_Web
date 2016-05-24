package managed;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.RequestScoped;



import ejbs.GestionCursosLocal;
import ejbs.GestionMatriculasLocal;

import entidades.Curso;
import entidades.Matricula;


@ManagedBean(name="consultarMatriculasCursoBean")
@RequestScoped
public class ConsultarMatriculasCursoBean {
	@EJB
	GestionCursosLocal gcursos;
	@EJB
	GestionMatriculasLocal gmatricula;
	
	private List<Curso> listaCursos;
	private List<Matricula> listaMatriculas;
	private Curso cur;
	private int idCurso;


	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public Curso getCur() {
		return cur;
	}

	public void setCur(Curso cur) {
		this.cur = cur;
	}

	public List<Curso> getListaCursos() {
		listaCursos = gcursos.consultarCursos();
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



	public ConsultarMatriculasCursoBean() {
		listaMatriculas =new ArrayList<>();
	}
	public void seleccionarCurso(){

		listaMatriculas = gmatricula.consultarMatriculaPorCurso(idCurso);
		
	}
	
}
