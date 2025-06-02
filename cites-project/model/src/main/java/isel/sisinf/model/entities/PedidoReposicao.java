package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IPedidoReposicao;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
public class PedidoReposicao implements IPedidoReposicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private Timestamp dataPedido;

    private Timestamp dataReposicao;

    @Column(nullable = false)
    private int maxOcupacao;

    @ManyToOne
    @JoinColumn(name = "estacao_id", nullable = false)
    private Estacao estacao;
}