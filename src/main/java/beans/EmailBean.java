package beans;

import entities.Email;
import dao.EmailDAO;
import util.MessagesUtil;

import javax.faces.bean.ManagedBean;
import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.event.RowEditEvent;

@ManagedBean
@WebServlet(name = "emailBean", value = "/email-bean")
public class EmailBean {

    Email emailSelected = new Email();
    List<Email> listaEmails = new ArrayList<>();

    public void delete() {
        try {
            EmailDAO.delete(this.emailSelected);
            MessagesUtil.successMessage("Email deletado com sucesso!");
        } catch (Exception e) {
            MessagesUtil.errorMessage("Erro ao deletar email: " + e.getMessage());
        }
    }

    public String save() {
        if (this.emailSelected.getDestinatario() == null
        || this.emailSelected.getCorpoEmail() == null
        || this.emailSelected.getDataEnvio() == null) {
            MessagesUtil.errorMessage("Todos os campos são obrigatórios!");
            return null;
        }
        try {
            this.emailSelected.setDataEnvio(new java.util.Date());
            EmailDAO.save(this.emailSelected);
            setEmailSelected(new Email());
            MessagesUtil.successMessage("Email enviado com sucesso!");
            return "listagem?faces-redirect=true";
        } catch (Exception e) {
            System.out.println("Erro ao salvar email: " + e.getMessage());
            MessagesUtil.errorMessage("Erro ao enviar email: " + e.getMessage());
            return null;
        }
    }

    public void update(RowEditEvent event) {
        try {
            Email email = (Email) event.getObject();
            EmailDAO.update(email);
            MessagesUtil.successMessage("Email atualizado com sucesso!");
        } catch (Exception e) {
            MessagesUtil.errorMessage("Erro ao atualizar email: " + e.getMessage());
        }
    }

    public void emitConfirmationMessage() {
        MessagesUtil.successMessage("Confirmação de leitura solicitada com sucesso.");
    }

    public void getQuantidadeEmails() {
        try {
            Integer size = EmailDAO.getCountOfEmails();
            MessagesUtil.successMessage("Total de emails: " + size);
        } catch (Exception e) {
            MessagesUtil.errorMessage("Erro ao contar emails: " + e.getMessage());
        }
    }

    public void setEmailSelected(Email emailSelected) {
        this.emailSelected = emailSelected;
    }

    public Email getEmailSelected() {
        return emailSelected;
    }
    public List<Email> getListaEmails() {
        if (this.listaEmails.size() != EmailDAO.getAll().size()) {
            this.listaEmails = EmailDAO.getAll();
        }
        return this.listaEmails;
    }
}
