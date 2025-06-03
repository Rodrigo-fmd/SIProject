package isel.sisinf.model.interfaces;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface ICarregamento {
    Timestamp getDttopup();
    void setDttopup(Timestamp dttopup);

    ICartao getCard();
    void setCard(ICartao card);

    BigDecimal getValue();
    void setValue(BigDecimal value);
}