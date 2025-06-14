package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IFuncionario;
import isel.sisinf.model.interfaces.IPedidoReposicao;
import isel.sisinf.model.interfaces.IReposicao;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "REPLACEMENT")
@NamedQuery(
        name = "Reposicao.findByKey",
        query = "SELECT r FROM Reposicao r WHERE r.number = :number"
)
public class Reposicao implements IReposicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @Column(nullable = false)
    private Timestamp dreplacement;

    @Column(length = 8)
    private String action;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "reporder", referencedColumnName = "dorder", nullable = false),
            @JoinColumn(name = "repstation", referencedColumnName = "station", nullable = false)
    })
    private PedidoReposicao pedidoReposicao;

    @ManyToOne
    @JoinColumn(name = "employee", referencedColumnName = "person", nullable = false)
    private Funcionario funcionario;

    @Override
    public void setPedidoReposicao(IPedidoReposicao pedidoReposicao) {
        this.pedidoReposicao = (PedidoReposicao) pedidoReposicao;
    }

    @Override
    public IPedidoReposicao getPedidoReposicao() {
        return this.pedidoReposicao;
    }

    @Override
    public IFuncionario getFuncionario() {
        return this.funcionario;
    }

    @Override
    public void setFuncionario(IFuncionario funcionario) {
        this.funcionario = (Funcionario) funcionario;
    }
}