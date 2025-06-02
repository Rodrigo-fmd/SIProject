package isel.sisinf.model.interfaces;

public interface IDoca {
    int getId();
    void setId(int id);

    int getNumero();
    void setNumero(int numero);

    String getEstado();
    void setEstado(String estado);

    IEstacao getEstacao();
    void setEstacao(IEstacao estacao);
}