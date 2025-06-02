package isel.sisinf.model.interfaces;

import java.sql.Timestamp;

public interface IPedidoReposicao {
    int getId();
    void setId(int id);

    Timestamp getDataPedido();
    void setDataPedido(Timestamp dataPedido);

    Timestamp getDataReposicao();
    void setDataReposicao(Timestamp dataReposicao);

    int getMaxOcupacao();
    void setMaxOcupacao(int maxOcupacao);
}