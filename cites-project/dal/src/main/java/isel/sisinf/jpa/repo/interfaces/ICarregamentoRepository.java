package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.jpa.repo.interfaces.datamapper.IDataMapper;
import isel.sisinf.model.entities.Carregamento;

import java.util.List;

public interface ICarregamentoRepository extends IRepository<Carregamento, List<Carregamento>, Integer>, IDataMapper<Carregamento> {
}
