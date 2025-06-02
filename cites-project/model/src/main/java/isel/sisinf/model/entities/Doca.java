package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IDoca;
import isel.sisinf.model.interfaces.IEstacao;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"estacao_id", "numero"})
)
@NamedQuery(
        name = "Doca.findByKey",
        query = "SELECT d FROM Doca d WHERE d.id = :id"
)
public class Doca implements IDoca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int numero;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private String estado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "estacao_id", nullable = false)
    private Estacao estacao;

    @Override
    public IEstacao getEstacao() { return estacao; }

    @Override
    public void setEstacao(IEstacao estacao) { this.estacao = (Estacao) estacao; }
}