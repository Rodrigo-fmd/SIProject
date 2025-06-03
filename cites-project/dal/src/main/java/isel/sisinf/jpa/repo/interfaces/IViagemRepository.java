package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.jpa.repo.interfaces.datamapper.IDataMapper;
import isel.sisinf.model.entities.Viagem;

import java.util.List;

public interface IViagemRepository extends IRepository<Viagem, List<Viagem>, Integer>, IDataMapper<Viagem>{

}