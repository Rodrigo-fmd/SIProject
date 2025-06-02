package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IViagem;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
public class Viagem implements IViagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Timestamp dataInicio;

    private Timestamp dataFim;

    @Column
    private Integer avaliacao;

    @Column
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "estacao_inicio_id", nullable = false)
    private Estacao estacaoInicio;

    @ManyToOne
    @JoinColumn(name = "estacao_destino_id")
    private Estacao estacaoDestino;

    @ManyToOne
    @JoinColumn(name = "utilizador_nif", nullable = false)
    private Utilizador utilizador;

    @ManyToOne
    @JoinColumn(name = "trotineta_id", nullable = false)
    private Trotineta trotineta;
}