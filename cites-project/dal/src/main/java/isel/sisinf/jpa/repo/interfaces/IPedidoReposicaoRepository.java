package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.jpa.repo.interfaces.datamapper.IDataMapper;
import isel.sisinf.model.entities.PedidoReposicao;

import java.util.List;

public interface IPedidoReposicaoRepository extends IRepository<PedidoReposicao, List<PedidoReposicao>, Integer>, IDataMapper<PedidoReposicao> {

}
