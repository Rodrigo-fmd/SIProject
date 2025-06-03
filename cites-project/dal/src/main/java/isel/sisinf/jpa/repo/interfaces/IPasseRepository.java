package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.jpa.repo.interfaces.datamapper.IDataMapper;
import isel.sisinf.model.entities.Passe;
import java.util.List;

public interface IPasseRepository extends IRepository<Passe, List<Passe>, Integer>, IDataMapper<Passe> {
}
