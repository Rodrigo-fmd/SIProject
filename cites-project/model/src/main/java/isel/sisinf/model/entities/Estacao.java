package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IEstacao;
import isel.sisinf.model.interfaces.ILocalizacao;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@NamedQuery(
        name = "Estacao.findByKey",
        query = "SELECT e FROM Estacao e WHERE e.id = :id"
)
public class Estacao implements IEstacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "localizacao_id", nullable = false)
    private Localizacao localizacao;

    @OneToMany(mappedBy = "estacao", cascade = CascadeType.ALL)
    private Set<Doca> docas;

    @Override
    public ILocalizacao getLocalizacao() { return localizacao; }

    @Override
    public void setLocalizacao(ILocalizacao localizacao) {
        this.localizacao = (Localizacao) localizacao;
    }
}