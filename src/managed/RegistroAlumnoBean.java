package managed;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

import ejbs.GestionAlumnosLocal;
import ejbs.GestionCursosLocal;
import entidades.Alumno;


@ManagedBean(name="registroAlumnoBean")
@RequestScoped
public class RegistroAlumnoBean {

	@EJB
	GestionAlumnosLocal galumno;
	private Alumno alumno;
	private String rptPwd;
	

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	
	public String getRptPwd() {
		return rptPwd;
	}

	public void setRptPwd(String rptPwd) {
		this.rptPwd = rptPwd;
	}

	public RegistroAlumnoBean() {
		alumno=new Alumno();
	}

	public void insertarAlumno(){
		
		galumno.registrarAlumno(alumno);
			// devuelve el nombre de la página a la que ha de ir, sin .xhtml
		
		
	}
	
	
}
