package isel.sisinf.model.interfaces;

import java.sql.Timestamp;

public interface IDoca {
    int getNumber();
    void setNumber(int number);

    IEstacao getStation();
    void setStation(IEstacao station);

    String getState();
    void setState(String state);

    ITrotineta getScooter();
    void setScooter(ITrotineta scooter);

    Timestamp getVersion();
    void setVersion(Timestamp version);
}