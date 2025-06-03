package isel.sisinf.model.interfaces;

import java.math.BigDecimal;

public interface IPasse {
    int getId();
    void setId(int id);

    BigDecimal getCredit();
    void setCredit(BigDecimal credit);

    String getTypeofcard();
    void setTypeofcard(String typeofcard);

    int getClient();
    void setClient(int client);
}