package isel.sisinf.model.interfaces;

import java.math.BigDecimal;

public interface ITrotineta {
    int getId();
    void setId(int id);

    int getMaxSpeed();
    void setMaxSpeed(int maxSpeed);

    int getAutonomy();
    void setAutonomy(int autonomy);

    int getWeight();
    void setWeight(int weight);

    String getModel();
    void setModel(String model);

    String getBrand();
    void setBrand(String brand);

    BigDecimal getPrice();
    void setPrice(BigDecimal price);

    IDoca getDoca();
    void setDoca(IDoca doca);
}