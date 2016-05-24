package managed;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import ejbs.GestionAdministracionLocal;
import ejbs.GestionAlumnosLocal;


@ManagedBean(name="loginBean")
@SessionScoped

// hay otras dos SessionScoped o ApplicationScoped) si no se pone nada lo toma como RequestScoped
public class LoginBean {
	@EJB
	GestionAdministracionLocal gadministrador;
	@EJB
	GestionAlumnosLocal galumno;

	private String usuario;
	private String password;

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// controlador de accion
	public String login(){
		
		if(gadministrador.estaRegistrado(usuario, password)){
			// devuelve el nombre de la página a la que ha de ir, sin .xhtml
			return "inicio";
		}
		else{
		
			if(galumno.estaRegistrado(usuario, password)){
				// devuelve el nombre de la página a la que ha de ir, sin .xhtml
				return "alumno";
			}
			else{
				return "error";
			}
		}
	}
}
