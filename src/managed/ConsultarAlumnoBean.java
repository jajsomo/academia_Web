package managed;



import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ejbs.GestionAlumnosLocal;
import entidades.Alumno;
import entidades.Curso;



@ManagedBean(name="consultarAlumnoBean")
@RequestScoped
public class ConsultarAlumnoBean {
	@EJB
	GestionAlumnosLocal galumno;
	    
	private Alumno alumno;
	private List<Alumno> listaAlumnos;
	
	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public List<Alumno> getListaAlumnos() {
		listaAlumnos = galumno.consultarAlumnos();
		return listaAlumnos;
	}

	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

	
	public void borrarAlumno(Alumno alumno){
		galumno.eliminarAlumno(alumno.getIdAlumno());
	}
	
}
