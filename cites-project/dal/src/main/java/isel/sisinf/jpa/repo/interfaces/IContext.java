package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.model.interfaces.IPasse;
import isel.sisinf.model.interfaces.IReferencia;

public interface IContext extends AutoCloseable {
    enum IsolationLevel {
        READ_UNCOMMITTED,
        READ_COMMITTED,
        REPEATABLE_READ,
        SERIALIZABLE
    }
    void beginTransaction();
    void beginTransaction(IsolationLevel isolationLevel);
    void commit();
    void flush();
    void clear();
    void persist();

    IEstacaoRepository getEstacoes();
    IViagemRepository getViagens();
    ITrotinetaRepository getTrotinetas();
    IUtilizadorRepository getUtilizadores();
    IFuncionarioRepository getFuncionarios();
    IDocaRepository getDocas();
    IReferenciaRepository getReferencias();
    ICarregamentoRepository getCarregamentos();
    IPedidoReposicaoRepository getPedidos();
    IModeloRepository getModelos();
    IPasseRepository getPasses();
    IReposicaoRepository getReposicoes();
}
