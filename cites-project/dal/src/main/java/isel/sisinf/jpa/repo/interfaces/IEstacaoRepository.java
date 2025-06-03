package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.jpa.repo.interfaces.datamapper.IDataMapper;
import isel.sisinf.model.entities.Estacao;
import java.util.List;

public interface IEstacaoRepository extends IRepository<Estacao, List<Estacao>, Integer>, IDataMapper<Estacao> {

}
