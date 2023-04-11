package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessagesUtil {
    public static void successMessage(String message) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success:", message);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

    public static void errorMessage(String message) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", message);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
}
