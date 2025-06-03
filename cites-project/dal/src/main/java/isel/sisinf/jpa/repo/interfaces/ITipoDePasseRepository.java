package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.jpa.repo.interfaces.datamapper.IDataMapper;
import isel.sisinf.model.entities.TipoDePasse;

import java.util.List;

public interface ITipoDePasseRepository extends IRepository<TipoDePasse, List<TipoDePasse>, String>, IDataMapper<TipoDePasse> {
}
