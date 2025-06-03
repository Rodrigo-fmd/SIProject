package isel.sisinf.model.interfaces;

import java.sql.Timestamp;
import isel.sisinf.model.entities.Trotineta;
import isel.sisinf.model.entities.Utilizador;
import isel.sisinf.model.entities.Estacao;

public interface IViagem {
    Timestamp getDinitial();
    void setDinitial(Timestamp dinitial);

    Trotineta getScooter();
    void setScooter(Trotineta scooter);

    String getComment();
    void setComment(String comment);

    Integer getEvaluation();
    void setEvaluation(Integer evaluation);

    Timestamp getDfinal();
    void setDfinal(Timestamp dfinal);

    Utilizador getClient();
    void setClient(Utilizador client);

    Estacao getStinitial();
    void setStinitial(Estacao stinitial);

    Estacao getStfinal();
    void setStfinal(Estacao stfinal);
}