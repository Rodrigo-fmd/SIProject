package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.jpa.repo.interfaces.datamapper.IDataMapper;
import isel.sisinf.model.entities.Viagem;
import isel.sisinf.model.entities.ViagemPK;

import java.util.List;

public interface IViagemRepository extends IRepository<Viagem, List<Viagem>, ViagemPK>, IDataMapper<Viagem>{
    List<Viagem> findAll();
}