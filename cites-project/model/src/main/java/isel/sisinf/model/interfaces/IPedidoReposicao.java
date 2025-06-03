package isel.sisinf.model.interfaces;

import java.sql.Timestamp;

public interface IPedidoReposicao {
    Timestamp getDorder();
    void setDorder(Timestamp dorder);

    Timestamp getDreplacement();
    void setDreplacement(Timestamp dreplacement);

    int getRoccupation();
    void setRoccupation(int roccupation);

    int getStation();
    void setStation(int station);
}