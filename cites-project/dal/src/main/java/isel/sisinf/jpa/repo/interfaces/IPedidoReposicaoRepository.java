package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.jpa.repo.interfaces.datamapper.IDataMapper;
import isel.sisinf.model.entities.PedidoReposicao;
import isel.sisinf.model.entities.PedidoReposicaoId;

import java.util.List;

public interface IPedidoReposicaoRepository extends IRepository<PedidoReposicao, List<PedidoReposicao>, PedidoReposicaoId>, IDataMapper<PedidoReposicao> {

}
