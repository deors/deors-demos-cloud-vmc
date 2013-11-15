package deors.demos.cloud.vmc.services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import deors.demos.cloud.vmc.entities.Codes;
import deors.demos.cloud.vmc.repositories.CodesDAO;

@Service("codesService")
@Transactional
public class CodesServiceImpl
    implements CodesService {

    private CodesDAO codesDAO;

    public CodesServiceImpl() {

        super();
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public Collection<? extends Codes> selectAll() {

        return codesDAO.selectAll();
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public Codes select(Codes criteria) {

        return codesDAO.select(criteria);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Codes insert(Codes record) {

        return codesDAO.insert(record);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int update(Codes record) {

        return codesDAO.update(record);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int delete(Codes record) {

        return codesDAO.delete(record);
    }

    public void setCodesDAO(CodesDAO codesDAO) {

        this.codesDAO = codesDAO;
    }
}
