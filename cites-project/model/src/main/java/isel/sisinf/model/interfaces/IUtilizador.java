package isel.sisinf.model.interfaces;

import isel.sisinf.model.entities.Passe;

public interface IUtilizador {
    public String getName();
    public void setName(String name);

    public String getNif();
    public void setNif(String nif);

    public String getEmail();
    public void setEmail(String email);

    public String getRegistingDate();
    public void setRegistingDate(String registingDate);

    public Passe getPasse();
}
