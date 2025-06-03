package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.jpa.repo.interfaces.datamapper.IDataMapper;
import isel.sisinf.model.entities.Utilizador;
import java.util.List;

public interface IUtilizadorRepository extends IRepository<Utilizador, List<Utilizador>, Integer>, IDataMapper<Utilizador> {

}