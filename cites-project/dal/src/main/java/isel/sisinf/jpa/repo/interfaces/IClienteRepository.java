package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.jpa.repo.interfaces.datamapper.IDataMapper;
import isel.sisinf.model.entities.Cliente;

import java.util.List;

public interface IClienteRepository extends IRepository<Cliente, List<Cliente>, Integer>, IDataMapper<Cliente> {
    List<Cliente> findAll();
}
