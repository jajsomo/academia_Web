package validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;



@FacesValidator(value="vPassword")
public class ValidadorPassword implements Validator {

	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		String pwd2=(String)arg2;
		
		UIInput pwd = (UIInput)arg1.findComponent("psw1");
		String pwd1=(String)pwd.getValue();
		
		/*
		 ExternaContext ex = arg0.getExternalContext();
		 HttpservletRequest request = (HttpServletRequest)ex.getRequest();
		 String pwd1 = request.getParameter("pwd");
		 */
		if(!pwd2.equals(pwd1)){
			FacesMessage fm = new FacesMessage("La contraseña no coincide");
			ValidatorException ex = new ValidatorException(fm);
			throw ex;
		}
		
	}

}
