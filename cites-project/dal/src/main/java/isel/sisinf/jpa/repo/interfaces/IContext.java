package isel.sisinf.jpa.repo.interfaces;



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
    void persist(Object entity);

    IEstacaoRepository getEstacoes();
    IViagemRepository getViagens();
    ITrotinetaRepository getTrotinetas();
    IFuncionarioRepository getFuncionarios();
    IDocaRepository getDocas();
    ICarregamentoRepository getCarregamentos();
    IPedidoReposicaoRepository getPedidos();
    IModeloRepository getModelos();
    IPasseRepository getPasses();
    IReposicaoRepository getReposicoes();
    ITipoDePasseRepository getTipoDePasses();
    IPessoaRepository getPessoas();
}
