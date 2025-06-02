package isel.sisinf.model.interfaces;

import java.sql.Timestamp;

public interface IReposicao {
    int getNumero();
    void setNumero(int numero);

    Timestamp getData();
    void setData(Timestamp data);
}