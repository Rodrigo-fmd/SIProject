package isel.sisinf.model.interfaces;

import java.sql.Timestamp;

public interface IReposicao {
    int getNumber();
    void setNumber(int number);

    Timestamp getDreplacement();
    void setDreplacement(Timestamp dreplacement);

    String getAction();
    void setAction(String action);

    IPedidoReposicao getPedidoReposicao();
    void setPedidoReposicao(IPedidoReposicao pedidoReposicao);

    IFuncionario getFuncionario();
    void setFuncionario(IFuncionario funcionario);
}