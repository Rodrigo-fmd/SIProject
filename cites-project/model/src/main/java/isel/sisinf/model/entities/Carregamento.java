package isel.sisinf.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "TOPUP")
@NamedQuery(
        name = "Carregamento.findByKey",
        query = "SELECT c FROM Carregamento c WHERE c.id = :id"
)
public class Carregamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Timestamp data;

    @Column(nullable = false)
    private int valor;

    @ManyToOne
    @JoinColumn(name = "scooter_id", referencedColumnName = "id")
    private Trotineta trotineta;

    @ManyToOne
    @JoinColumn(name = "funcionario_nif", referencedColumnName = "nif")
    private Funcionario funcionario;
}