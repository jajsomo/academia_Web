package managed;



import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import ejbs.GestionCursosLocal;
import entidades.Curso;



@ManagedBean(name="cursoBean")
@RequestScoped
public class CursoBean {
	@EJB
	GestionCursosLocal gcursos;;
	private Curso curso;

	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public CursoBean() {
		super();
		curso = new Curso();

	}
	public String registrarCurso(){

		curso.setPlazasLibres(curso.getPlazas());
		gcursos.registrarCurso(curso);
			// devuelve el nombre de la página a la que ha de ir, sin .xhtml
			return "inicio";
	
	}
	
}
