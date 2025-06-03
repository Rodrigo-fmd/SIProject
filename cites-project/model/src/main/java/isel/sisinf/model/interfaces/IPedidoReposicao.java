package isel.sisinf.model.interfaces;

import isel.sisinf.model.entities.Estacao;

import java.sql.Timestamp;

public interface IPedidoReposicao {
    Timestamp getDorder();
    void setDorder(Timestamp dorder);

    Timestamp getDreplacement();
    void setDreplacement(Timestamp dreplacement);

    int getRoccupation();
    void setRoccupation(int roccupation);

    void setStation(Estacao station);
    Estacao getStation();
}