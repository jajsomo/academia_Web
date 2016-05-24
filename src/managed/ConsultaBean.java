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
import ejbs.GestionMatriculasLocal;
import entidades.Alumno;
import entidades.Curso;
import entidades.Matricula;


@ManagedBean(name="consultaBean")
@RequestScoped
public class ConsultaBean {
	
	private int seleccion;

	public int getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(int seleccion) {
		this.seleccion = seleccion;
	}

	
	public String consultar(){

		if (seleccion == 1){
			return  "consultaMatriculasAlumno";
		}
		else{
			return "consultaMatriculasCurso";
			
		}
	}
}
