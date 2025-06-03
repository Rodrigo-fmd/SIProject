package isel.sisinf.model.interfaces;

import java.sql.Timestamp;

public interface ICliente {
    int getPerson();
    void setPerson(int person);

    Timestamp getDtregister();
    void setDtregister(Timestamp dtregister);
}