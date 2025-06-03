package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.jpa.repo.interfaces.datamapper.IDataMapper;
import isel.sisinf.model.entities.Pessoa;
import java.util.List;

public interface IPessoaRepository extends IRepository<Pessoa, List<Pessoa>, Integer>, IDataMapper<Pessoa> {

}