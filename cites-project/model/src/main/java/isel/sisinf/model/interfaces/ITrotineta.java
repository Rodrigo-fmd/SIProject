package isel.sisinf.model.interfaces;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface ITrotineta {
    int getId();
    void setId(int id);

    BigDecimal getWeight();
    void setWeight(BigDecimal weight);

    BigDecimal getMaxVelocity();
    void setMaxVelocity(BigDecimal maxVelocity);

    int getBattery();
    void setBattery(int battery);

    IModel getModel();
    void setModel(IModel model);

    Timestamp getVersion();
    void setVersion(Timestamp version);
}