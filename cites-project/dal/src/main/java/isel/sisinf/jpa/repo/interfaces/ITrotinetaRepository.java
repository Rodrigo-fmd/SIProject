package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.jpa.repo.interfaces.datamapper.IDataMapper;
import isel.sisinf.model.entities.Trotineta;
import java.util.List;

public interface ITrotinetaRepository extends IRepository<Trotineta, List<Trotineta>, Integer>, IDataMapper<Trotineta> {

}