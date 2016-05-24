package managed;



import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ejbs.GestionCursosLocal;
import entidades.Curso;



@ManagedBean(name="borrarCursoBean")
@RequestScoped
public class BorrarCursoBean {
	@EJB
	GestionCursosLocal gcurso;
	    
	private Curso curso;
	private List<Curso> cursos;

	
	public List<Curso> getCursos() {
		cursos = gcurso.consultarCursos();
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
		curso.setPlazasLibres(curso.getPlazas());
		gcurso.eliminarCurso(curso.getIdCurso());
	}
	
}
