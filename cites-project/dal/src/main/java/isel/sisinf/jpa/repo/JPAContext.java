package isel.sisinf.jpa.repo;

import isel.sisinf.jpa.repo.interfaces.*;
import isel.sisinf.model.entities.*;
import jakarta.persistence.*;
import org.eclipse.persistence.sessions.DatabaseLogin;
import org.eclipse.persistence.sessions.Session;

import java.util.List;

public class JPAContext implements IContext {
    private final EntityManagerFactory emf;
    private final EntityManager em;
    private EntityTransaction tx;
    private int txCount = 0;

    private final IEstacaoRepository estacaoRepo;
    private final IViagemRepository viagemRepo;
    private final ITrotinetaRepository trotinetaRepo;
    private final IUtilizadorRepository utilizadorRepo;
    private final IFuncionarioRepository funcionarioRepo;
    private final IDocaRepository docaRepo;
    private final ICarregamentoRepository carregamentoRepo;
    private final IPedidoReposicaoRepository pedidoRepo;
    private final IModeloRepository modeloRepo;
    private final IPasseRepository passeRepo;
    private final IReposicaoRepository reposicaoRepo;
    private final ITipoDePasseRepository tipoDePasseRepo;

    public JPAContext() {
        this("cites-pu");
    }

    public JPAContext(String persistenceCtx) {
        this.emf = Persistence.createEntityManagerFactory(persistenceCtx);
        this.em = emf.createEntityManager();
        this.estacaoRepo = new EstacaoRepository();
        this.viagemRepo = new ViagemRepository();
        this.trotinetaRepo = new TrotinetaRepository();
        this.utilizadorRepo = new UtilizadorRepository();
        this.funcionarioRepo = new FuncionarioRepository();
        this.docaRepo = new DocaRepository();
        this.carregamentoRepo = new CarregamentoRepository();
        this.pedidoRepo = new PedidoReposicaoRepository();
        this.modeloRepo = new ModeloRepository();
        this.passeRepo = new PasseRepository();
        this.reposicaoRepo = new ReposicaoRepository();
        this.tipoDePasseRepo = new TipoDePasseRepository();
    }

    // Métodos de transação
    @Override
    public void beginTransaction() {
        if (tx == null) {
            tx = em.getTransaction();
            tx.begin();
            txCount = 0;
        }
        ++txCount;
    }

    @Override
    public void beginTransaction(IsolationLevel isolationLevel) {
        Session session =em.unwrap(Session.class);
        DatabaseLogin databaseLogin = (DatabaseLogin) session.getDatasourceLogin();
        System.out.println(databaseLogin.getTransactionIsolation());

        int isolation = DatabaseLogin.TRANSACTION_READ_COMMITTED;
        if(isolationLevel == IsolationLevel.READ_UNCOMMITTED)
            isolation = DatabaseLogin.TRANSACTION_READ_UNCOMMITTED;
        else if(isolationLevel == IsolationLevel.REPEATABLE_READ)
            isolation = DatabaseLogin.TRANSACTION_REPEATABLE_READ;
        else if(isolationLevel == IsolationLevel.SERIALIZABLE)
            isolation = DatabaseLogin.TRANSACTION_SERIALIZABLE;

        databaseLogin.setTransactionIsolation(isolation);
        beginTransaction();
    }

    @Override
    public void commit() {
        --txCount;
        if (txCount == 0 && tx != null) {
            em.flush();
            tx.commit();
            tx = null;
        }
    }

    @Override
    public void flush() { em.flush(); }

    @Override
    public void clear() { em.clear(); }

    @Override
    public void persist(Object entity) { em.persist(entity); }

    // Getters dos repositórios
    @Override
    public IEstacaoRepository getEstacoes() { return estacaoRepo; }

    @Override
    public IViagemRepository getViagens() { return viagemRepo; }

    @Override
    public ITrotinetaRepository getTrotinetas() { return trotinetaRepo; }

    @Override
    public IUtilizadorRepository getUtilizadores() { return utilizadorRepo; }

    @Override
    public IFuncionarioRepository getFuncionarios() { return funcionarioRepo; }

    @Override
    public IDocaRepository getDocas() { return docaRepo; }

    @Override
    public ICarregamentoRepository getCarregamentos() { return carregamentoRepo; }

    @Override
    public IPedidoReposicaoRepository getPedidos() { return pedidoRepo; }

    @Override
    public IModeloRepository getModelos() { return modeloRepo; }

    @Override
    public IPasseRepository getPasses() { return passeRepo; }

    @Override
    public IReposicaoRepository getReposicoes() { return reposicaoRepo; }

    @Override
    public ITipoDePasseRepository getTipoDePasses() { return tipoDePasseRepo; }

    @Override
    public void close() {
        if (tx != null && tx.isActive()) tx.rollback();
        em.close();
        emf.close();
    }

    protected <T> List<T> helperQueryImpl(String jpql, Class<T> clazz, Object... params) {
        TypedQuery<T> q = em.createQuery(jpql, clazz);
        for (int i = 0; i < params.length; ++i) {
            q.setParameter(i + 1, params[i]);
        }
        return q.getResultList();
    }

    // Helpers genéricos para CRUD
    protected <T> T helperCreate(T entity) {
        beginTransaction();
        em.persist(entity);
        commit();
        return entity;
    }

    protected <T> T helperUpdate(T entity) {
        beginTransaction();
        T merged = em.merge(entity);
        commit();
        return merged;
    }

    protected <T> T helperDelete(T entity) {
        beginTransaction();
        em.remove(em.contains(entity) ? entity : em.merge(entity));
        commit();
        return entity;
    }

    protected class EstacaoRepository implements IEstacaoRepository {
        @Override
        public Estacao findByKey(Integer key) {
            return em.createNamedQuery("Estacao.findByKey", Estacao.class)
                    .setParameter("id", key)
                    .getSingleResult();
        }
        @Override
        public List<Estacao> find(String jpql, Object... params) {
            return helperQueryImpl(jpql, Estacao.class, params);
        }
        @Override
        public Estacao Create(Estacao entity) { return helperCreate(entity); }
        @Override
        public Estacao Update(Estacao entity) { return helperUpdate(entity); }
        @Override
        public Estacao Delete(Estacao entity) { return helperDelete(entity); }
    }

    protected class ViagemRepository implements IViagemRepository {
        @Override
        public Viagem findByKey(ViagemPK key) {
            return em.createNamedQuery("Viagem.findByKey", Viagem.class)
                    .setParameter("dinitial", key.getDinitial())
                    .setParameter("scooter", key.getScooter())
                    .getSingleResult();
        }
        @Override
        public List<Viagem> findAll() {
            return em.createNamedQuery("Viagem.findAll", Viagem.class).getResultList();
        }
        @Override
        public List<Viagem> find(String jpql, Object... params) {
            return helperQueryImpl(jpql, Viagem.class, params);
        }
        @Override
        public Viagem Create(Viagem entity) { return helperCreate(entity); }
        @Override
        public Viagem Update(Viagem entity) { return helperUpdate(entity); }
        @Override
        public Viagem Delete(Viagem entity) { return helperDelete(entity); }
    }

    protected class TrotinetaRepository implements ITrotinetaRepository {
        @Override
        public Trotineta findByKey(Integer key) {
            return em.createNamedQuery("Trotineta.findByKey", Trotineta.class)
                    .setParameter("id", key)
                    .getSingleResult();
        }
        @Override
        public List<Trotineta> findAll() {
            return em.createNamedQuery("Trotineta.findAll", Trotineta.class).getResultList();
        }
        @Override
        public List<Trotineta> find(String jpql, Object... params) {
            return helperQueryImpl(jpql, Trotineta.class, params);
        }
        @Override
        public Trotineta Create(Trotineta entity) { return helperCreate(entity); }
        @Override
        public Trotineta Update(Trotineta entity) { return helperUpdate(entity); }
        @Override
        public Trotineta Delete(Trotineta entity) { return helperDelete(entity); }
    }

    protected class UtilizadorRepository implements IUtilizadorRepository {
        @Override
        public Pessoa findByKey(String key) {
            return em.createNamedQuery("Utilizador.findByKey", Pessoa.class)
                    .setParameter("id", key)
                    .getSingleResult();
        }
        @Override
        public List<Pessoa> find(String jpql, Object... params) {
            return helperQueryImpl(jpql, Pessoa.class, params);
        }
        @Override
        public Pessoa Create(Pessoa entity) { return helperCreate(entity); }
        @Override
        public Pessoa Update(Pessoa entity) { return helperUpdate(entity); }
        @Override
        public Pessoa Delete(Pessoa entity) { return helperDelete(entity); }
    }

    protected class FuncionarioRepository implements IFuncionarioRepository {
        @Override
        public Funcionario findByKey(String key) {
            return em.createNamedQuery("Funcionario.findByKey", Funcionario.class)
                    .setParameter("personId", key)
                    .getSingleResult();
        }
        @Override
        public List<Funcionario> find(String jpql, Object... params) {
            return helperQueryImpl(jpql, Funcionario.class, params);
        }
        @Override
        public Funcionario Create(Funcionario entity) { return helperCreate(entity); }
        @Override
        public Funcionario Update(Funcionario entity) { return helperUpdate(entity); }
        @Override
        public Funcionario Delete(Funcionario entity) { return helperDelete(entity); }
    }

    protected class DocaRepository implements IDocaRepository {
        @Override
        public Doca findByKey(Integer key) {
            return em.createNamedQuery("Doca.findByKey", Doca.class)
                    .setParameter("number", key)
                    .getSingleResult();
        }
        @Override
        public List<Doca> findAll() {
            return em.createNamedQuery("Doca.findAll", Doca.class).getResultList();
        }
        @Override
        public List<Doca> find(String jpql, Object... params) {
            return helperQueryImpl(jpql, Doca.class, params);
        }
        @Override
        public Doca Create(Doca entity) { return helperCreate(entity); }
        @Override
        public Doca Update(Doca entity) { return helperUpdate(entity); }
        @Override
        public Doca Delete(Doca entity) { return helperDelete(entity); }
    }

    protected class CarregamentoRepository implements ICarregamentoRepository {
        @Override
        public Carregamento findByKey(Integer key) {
            return em.createNamedQuery("Carregamento.findByKey", Carregamento.class)
                    .setParameter("id", key)
                    .getSingleResult();
        }
        @Override
        public List<Carregamento> find(String jpql, Object... params) {
            return helperQueryImpl(jpql, Carregamento.class, params);
        }
        @Override
        public Carregamento Create(Carregamento entity) { return helperCreate(entity); }
        @Override
        public Carregamento Update(Carregamento entity) { return helperUpdate(entity); }
        @Override
        public Carregamento Delete(Carregamento entity) { return helperDelete(entity); }
    }

    protected class PedidoReposicaoRepository implements IPedidoReposicaoRepository {
        @Override
        public PedidoReposicao findByKey(PedidoReposicaoId key) {
            return em.createNamedQuery("PedidoReposicao.findByKey", PedidoReposicao.class)
                    .setParameter("dorder", key.getDorder())
                    .setParameter("station", key.getStation())
                    .getSingleResult();
        }
        @Override
        public List<PedidoReposicao> find(String jpql, Object... params) {
            return helperQueryImpl(jpql, PedidoReposicao.class, params);
        }
        @Override
        public PedidoReposicao Create(PedidoReposicao entity) { return helperCreate(entity); }
        @Override
        public PedidoReposicao Update(PedidoReposicao entity) { return helperUpdate(entity); }
        @Override
        public PedidoReposicao Delete(PedidoReposicao entity) { return helperDelete(entity); }
    }

    protected class ModeloRepository implements IModeloRepository {
        @Override
        public Modelo findByKey(Integer key) {
            return em.createNamedQuery("Modelo.findByKey", Modelo.class)
                    .setParameter("number", key)
                    .getSingleResult();
        }
        @Override
        public List<Modelo> find(String jpql, Object... params) {
            return helperQueryImpl(jpql, Modelo.class, params);
        }
        @Override
        public Modelo Create(Modelo entity) { return helperCreate(entity); }
        @Override
        public Modelo Update(Modelo entity) { return helperUpdate(entity); }
        @Override
        public Modelo Delete(Modelo entity) { return helperDelete(entity); }
    }

    protected class PasseRepository implements IPasseRepository {
        @Override
        public Passe findByKey(Integer key) {
            return em.createNamedQuery("Passe.findByKey", Passe.class)
                    .setParameter("id", key)
                    .getSingleResult();
        }
        @Override
        public List<Passe> find(String jpql, Object... params) {
            return helperQueryImpl(jpql, Passe.class, params);
        }
        @Override
        public Passe Create(Passe entity) { return helperCreate(entity); }
        @Override
        public Passe Update(Passe entity) { return helperUpdate(entity); }
        @Override
        public Passe Delete(Passe entity) { return helperDelete(entity); }
    }

    protected class ReposicaoRepository implements IReposicaoRepository {
        @Override
        public Reposicao findByKey(Integer key) {
            return em.createNamedQuery("Reposicao.findByKey", Reposicao.class)
                    .setParameter("number", key)
                    .getSingleResult();
        }
        @Override
        public List<Reposicao> find(String jpql, Object... params) {
            return helperQueryImpl(jpql, Reposicao.class, params);
        }
        @Override
        public Reposicao Create(Reposicao entity) { return helperCreate(entity); }
        @Override
        public Reposicao Update(Reposicao entity) { return helperUpdate(entity); }
        @Override
        public Reposicao Delete(Reposicao entity) { return helperDelete(entity); }
    }

    protected class TipoDePasseRepository implements ITipoDePasseRepository {
        @Override
        public TipoDePasse findByKey(String key) {
            return em.createNamedQuery("TipoDePasse.findByKey", TipoDePasse.class)
                    .setParameter("reference", key)
                    .getSingleResult();
        }
        @Override
        public List<TipoDePasse> find(String jpql, Object... params) {
            return helperQueryImpl(jpql, TipoDePasse.class, params);
        }
        @Override
        public TipoDePasse Create(TipoDePasse entity) { return helperCreate(entity); }
        @Override
        public TipoDePasse Update(TipoDePasse entity) { return helperUpdate(entity); }
        @Override
        public TipoDePasse Delete(TipoDePasse entity) { return helperDelete(entity); }
    }
}