package isel.sisinf.jpa.repo.interfaces;

import isel.sisinf.jpa.repo.interfaces.datamapper.IDataMapper;
import isel.sisinf.model.entities.Doca;
import isel.sisinf.model.entities.Trotineta;

import java.sql.Timestamp;
import java.util.List;

public interface IDocaRepository extends IRepository<Doca, List<Doca>, Integer>, IDataMapper<Doca> {
    List<Doca> findAll();
    int updateDockWithScooter(int dockId, Trotineta trotineta, String state, Timestamp newVersion, Timestamp oldVersion);}
