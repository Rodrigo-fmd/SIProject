package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IUtilizador;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@NamedQuery(
        name = "Utilizador.findByKey",
        query = "SELECT u FROM Utilizador u WHERE u.nif = :nif"
)
public class Utilizador implements IUtilizador {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private String nif;
    @Column(unique = true, nullable = false)
    private String email;
    private String registingDate;

    @OneToOne(mappedBy = "utilizador", fetch = FetchType.LAZY)
    private Passe passe;
}
