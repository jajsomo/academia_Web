package managed;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import ejbs.GestionAlumnosLocal;
import ejbs.GestionCursosLocal;
import ejbs.GestionMatriculasLocal;
import entidades.Alumno;
import entidades.Curso;
import entidades.Matricula;

@ManagedBean(name="ponerNotasBean")
@SessionScoped
public class PonerNotasBean {
	@EJB
	GestionCursosLocal gcursos;
	@EJB
	GestionAlumnosLocal galumnos;
	@EJB
	GestionMatriculasLocal gmatricula;
	
	private int idCurso;
	private int idMatricula;
	private Double nota;
	private Matricula matricula;
	private List<Curso> listaCursos;
	private List<Matricula> listaMatriculas;
	public Curso selectedCurso;	
	public Matricula selectedMatricula;

	public Curso getSelectedCurso() {
		return selectedCurso;
	}

	public void setSelectedCurso(Curso selectedCurso) {
		this.selectedCurso = selectedCurso;
	}
	
	public Matricula getSelectedMatricula() {
		return selectedMatricula;
	}

	public void setSelectedMatricula(Matricula selectedMatricula) {
		this.selectedMatricula = selectedMatricula;
	}

	public int getIdCurso() {
		listaMatriculas = gmatricula.consultarMatriculaPorCurso(idCurso);
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	
	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public List<Curso> getListaCursos() {
		listaCursos = gcursos.consultarCursos();
		listaMatriculas = gmatricula.consultarMatriculas();
		return listaCursos;
	}

	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}

	public List<Matricula> getListaMatriculas() {
		listaMatriculas = gmatricula.consultarMatriculaPorCurso(idCurso);
		
		return listaMatriculas;
	}

	public void setListaMatriculas(List<Matricula> listaMatriculas) {
		this.listaMatriculas = listaMatriculas;
	}

	public PonerNotasBean() {
		super();
		listaCursos = new ArrayList<Curso>();
		listaMatriculas = new ArrayList<Matricula>();

	}
	public void seleccionaCurso(SelectEvent event){
	    idCurso = ((Curso) event.getObject()).getIdCurso();
		listaMatriculas = gmatricula.consultarMatriculaPorCurso(idCurso);
	}
	public void seleccionaAlumno(SelectEvent event){
		matricula = (Matricula) event.getObject();
		idMatricula = matricula.getIdMatriculas();
		List<Matricula> lista =gmatricula.consultarMatriculaPorAlumno(matricula.getAlumno().getIdAlumno());
		List<Curso> listaApuntados;
		listaApuntados = gcursos.consultarMatriculas(lista);
				
	}
	public void seleccionarMatricula(){
		matricula = gmatricula.consultarMatriculaPorIdMatricula(idMatricula);
	}
	public String ponerNotas(){
		
		System.out.println("Entro en Poner notas: "+ matricula.getCurso().getNombre() +" ");

		if ((nota>=0) && (nota<=10)){
			gmatricula.ponerNota(matricula, nota);
			nota =0.0;
			return "";
		}
		else{
			return "error";
		}

	}

}
