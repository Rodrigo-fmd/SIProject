package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.jpa.repo.interfaces.datamapper.IDataMapper;
import isel.sisinf.model.entities.Referencia;

import java.util.List;

public interface IReferenciaRepository extends IRepository<Referencia, List<Referencia>, Integer>, IDataMapper<Referencia> {
}
