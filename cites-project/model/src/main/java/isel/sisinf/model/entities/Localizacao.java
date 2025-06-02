package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.ILocalizacao;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@NamedQuery(
        name = "Localizacao.findByKey",
        query = "SELECT l FROM Localizacao l WHERE l.id = :id"
)
public class Localizacao implements ILocalizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;
}