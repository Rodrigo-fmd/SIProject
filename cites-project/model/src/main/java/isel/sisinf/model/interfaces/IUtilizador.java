package isel.sisinf.model.interfaces;

public interface IUtilizador {
    int getId();
    void setId(int id);

    String getEmail();
    void setEmail(String email);

    int getTaxnumber();
    void setTaxnumber(int taxnumber);

    String getName();
    void setName(String name);
}