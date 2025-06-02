package isel.sisinf.model.interfaces;

import java.sql.Timestamp;

public interface IViagem {
    int getId();
    void setId(int id);

    Timestamp getDataInicio();
    void setDataInicio(Timestamp dataInicio);

    Timestamp getDataFim();
    void setDataFim(Timestamp dataFim);

    Integer getAvaliacao();
    void setAvaliacao(Integer avaliacao);

    String getMensagem();
    void setMensagem(String mensagem);
}