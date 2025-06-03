package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IFuncionario;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Funcionario implements IFuncionario {
    @Id
    @Column(unique = true, nullable = false)
    private String nif;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private int numero;

    @OneToOne
    @JoinColumn(name = "utilizador_nif", nullable = false)
    private Utilizador utilizador;
}