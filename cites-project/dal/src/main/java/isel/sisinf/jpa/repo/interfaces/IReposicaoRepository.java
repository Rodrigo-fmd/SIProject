package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.jpa.repo.interfaces.datamapper.IDataMapper;
import isel.sisinf.model.entities.Reposicao;
import isel.sisinf.model.entities.Utilizador;

import java.util.List;

public interface IReposicaoRepository extends IRepository<Reposicao, List<Reposicao>, Integer>, IDataMapper<Reposicao> {
}
