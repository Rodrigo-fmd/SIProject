package isel.sisinf.model.interfaces;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface ICarregamento {
    Timestamp getDttopup();
    void setDttopup(Timestamp dttopup);

    IPasse getCard();
    void setCard(IPasse card);

    BigDecimal getValue();
    void setValue(BigDecimal value);
}