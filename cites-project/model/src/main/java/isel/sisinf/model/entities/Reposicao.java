package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IReposicao;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
public class Reposicao implements IReposicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;

    @Column(nullable = false)
    private Timestamp data;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private PedidoReposicao pedido;

    @ManyToOne
    @JoinColumn(name = "funcionario_nif", nullable = false)
    private Funcionario funcionario;
}