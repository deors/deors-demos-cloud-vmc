package deors.demos.cloud.vmc.repositories;

import java.util.Collection;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import deors.demos.cloud.vmc.entities.Codes;
import deors.demos.cloud.vmc.entities.CodesImpl;

@Repository("codesDAO")
public class HibernateCodesDAOImpl
    extends HibernateTemplate
    implements CodesDAO {

    public HibernateCodesDAOImpl() {

        super();
    }

    public Collection<? extends Codes> selectAll() {

        return loadAll(CodesImpl.class);
    }

    public Codes select(Codes criteria) {

        return (Codes) find("from CodesImpl where code=?", criteria.getCode()).get(0);
    }

    public Codes insert(Codes record) {

        save(record);
        return record;
    }

    public int update(Codes record) {

        super.update(record);
        return 1;
    }

    public int delete(Codes record) {

        super.delete(record);
        return 1;
    }
}
