package deors.demos.cloud.vmc.repositories;

import java.util.Collection;

import deors.demos.cloud.vmc.entities.Codes;

public interface CodesDAO {

    Collection<? extends Codes> selectAll();

    Codes select(Codes criteria);

    Codes insert(Codes record);

    int update(Codes record);

    int delete(Codes record);
}
