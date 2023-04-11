package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Email {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String destinatario;
    @Column(nullable = false)
    private String corpoEmail;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataEnvio;
    @Column
    private Boolean confirmaLeitura;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getCorpoEmail() {
        return corpoEmail;
    }

    public void setCorpoEmail(String corpoEmail) {
        this.corpoEmail = corpoEmail;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Boolean getConfirmaLeitura() {
        return confirmaLeitura;
    }

    public void setConfirmaLeitura(Boolean confirmaLeitura) {
        this.confirmaLeitura = confirmaLeitura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(id, email.id) && Objects.equals(destinatario, email.destinatario) && Objects.equals(corpoEmail, email.corpoEmail) && Objects.equals(dataEnvio, email.dataEnvio) && Objects.equals(confirmaLeitura, email.confirmaLeitura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destinatario, corpoEmail, dataEnvio, confirmaLeitura);
    }
}
