package isel.sisinf.jpa.repo;

import isel.sisinf.jpa.repo.interfaces.*;
import isel.sisinf.model.entities.*;
import jakarta.persistence.*;

public class JPAContext implements IContext {
    private final EntityManagerFactory emf;
    private final EntityManager em;
    private EntityTransaction tx;
    private int txCount = 0;

    private final IEstacaoRepository estacaoRepo;
    private final IViagemRepository viagemRepo;
    private final ITrotinetaRepository trotinetaRepo;
    private final IUtilizadorRepository utilizadorRepo;

    public JPAContext() {
        this("cites-pu");
    }

    public JPAContext(String persistenceUnit) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnit);
        this.em = emf.createEntityManager();
        this.estacaoRepo = new EstacaoRepository();
        this.viagemRepo = new ViagemRepository();
        this.trotinetaRepo = new TrotinetaRepository();
        this.utilizadorRepo = new UtilizadorRepository();
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
        beginTransaction();
        // Implementação do nível de isolamento se necessário
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
    public void persist() { em.flush(); }

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
    public void close() {
        if (tx != null && tx.isActive()) tx.rollback();
        em.close();
        emf.close();
    }

    protected class EstacaoRepository implements IEstacaoRepository {
        @Override
        public Estacao findByKey(Integer key) {
            return em.find(Estacao.class, key);
        }
        @Override
        public java.util.List<Estacao> find(String jpql, Object... params) {
            TypedQuery<Estacao> q = em.createQuery(jpql, Estacao.class);
            for (int i = 0; i < params.length; ++i)
                q.setParameter(i + 1, params[i]);
            return q.getResultList();
        }
        @Override
        public Estacao Create(Estacao entity) {
            beginTransaction();
            em.persist(entity);
            commit();
            return entity;
        }
        @Override
        public Estacao Update(Estacao entity) {
            beginTransaction();
            Estacao merged = em.merge(entity);
            commit();
            return merged;
        }
        @Override
        public Estacao Delete(Estacao entity) {
            beginTransaction();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            commit();
            return entity;
        }
    }

    protected class ViagemRepository implements IViagemRepository {
        @Override
        public Viagem findByKey(Integer key) {
            return em.find(Viagem.class, key);
        }
        @Override
        public java.util.List<Viagem> find(String jpql, Object... params) {
            TypedQuery<Viagem> q = em.createQuery(jpql, Viagem.class);
            for (int i = 0; i < params.length; ++i)
                q.setParameter(i + 1, params[i]);
            return q.getResultList();
        }
        @Override
        public Viagem create(Viagem entity) {
            beginTransaction();
            em.persist(entity);
            commit();
            return entity;
        }
        @Override
        public Viagem update(Viagem entity) {
            beginTransaction();
            Viagem merged = em.merge(entity);
            commit();
            return merged;
        }
        @Override
        public Viagem delete(Viagem entity) {
            beginTransaction();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            commit();
            return entity;
        }
    }

    protected class TrotinetaRepository implements ITrotinetaRepository {
        @Override
        public Trotineta findByKey(Integer key) {
            return em.find(Trotineta.class, key);
        }
        @Override
        public java.util.List<Trotineta> find(String jpql, Object... params) {
            TypedQuery<Trotineta> q = em.createQuery(jpql, Trotineta.class);
            for (int i = 0; i < params.length; ++i)
                q.setParameter(i + 1, params[i]);
            return q.getResultList();
        }
        @Override
        public Trotineta create(Trotineta entity) {
            beginTransaction();
            em.persist(entity);
            commit();
            return entity;
        }
        @Override
        public Trotineta update(Trotineta entity) {
            beginTransaction();
            Trotineta merged = em.merge(entity);
            commit();
            return merged;
        }
        @Override
        public Trotineta delete(Trotineta entity) {
            beginTransaction();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            commit();
            return entity;
        }
    }

    protected class UtilizadorRepository implements IUtilizadorRepository {
        @Override
        public Utilizador findByKey(Integer key) {
            return em.find(Utilizador.class, key);
        }
        @Override
        public java.util.List<Utilizador> find(String jpql, Object... params) {
            TypedQuery<Utilizador> q = em.createQuery(jpql, Utilizador.class);
            for (int i = 0; i < params.length; ++i)
                q.setParameter(i + 1, params[i]);
            return q.getResultList();
        }
        @Override
        public Utilizador create(Utilizador entity) {
            beginTransaction();
            em.persist(entity);
            commit();
            return entity;
        }
        @Override
        public Utilizador update(Utilizador entity) {
            beginTransaction();
            Utilizador merged = em.merge(entity);
            commit();
            return merged;
        }
        @Override
        public Utilizador delete(Utilizador entity) {
            beginTransaction();
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            commit();
            return entity;
        }
    }
}