package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.jpa.repo.interfaces.datamapper.IDataMapper;
import isel.sisinf.model.entities.Doca;
import isel.sisinf.model.entities.Viagem;

import java.util.List;

public interface IDocaRepository extends IRepository<Doca, List<Doca>, Integer>, IDataMapper<Doca> {
    List<Doca> findAll();
}
