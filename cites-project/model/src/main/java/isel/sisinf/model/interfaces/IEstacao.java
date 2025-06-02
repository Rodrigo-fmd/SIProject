package isel.sisinf.model.interfaces;

public interface IEstacao {
    int getId();
    void setId(int id);

    ILocalizacao getLocalizacao();
    void setLocalizacao(ILocalizacao localizacao);
}