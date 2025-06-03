package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.jpa.repo.interfaces.datamapper.IDataMapper;
import isel.sisinf.model.entities.Funcionario;

import java.util.List;

public interface IFuncionarioRepository extends IRepository<Funcionario, List<Funcionario>, String>, IDataMapper<Funcionario> {
}
