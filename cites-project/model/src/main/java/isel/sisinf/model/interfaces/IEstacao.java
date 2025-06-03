package isel.sisinf.model.interfaces;

import java.math.BigDecimal;

public interface IEstacao {
    int getId();
    void setId(int id);

    BigDecimal getLatitude();
    void setLatitude(BigDecimal latitude);

    BigDecimal getLongitude();
    void setLongitude(BigDecimal longitude);
}