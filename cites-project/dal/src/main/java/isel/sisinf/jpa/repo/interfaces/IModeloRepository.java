package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.jpa.repo.interfaces.datamapper.IDataMapper;
import isel.sisinf.model.entities.Modelo;

import java.util.List;

public interface IModeloRepository extends IRepository<Modelo, List<Modelo>, Integer>, IDataMapper<Modelo> {
}
