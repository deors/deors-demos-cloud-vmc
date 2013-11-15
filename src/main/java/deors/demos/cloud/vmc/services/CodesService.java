package deors.demos.cloud.vmc.services;

import java.util.Collection;

import deors.demos.cloud.vmc.entities.Codes;
import deors.demos.cloud.vmc.repositories.CodesDAO;

public interface CodesService {

    void setCodesDAO(CodesDAO codesDAO);

    Collection<? extends Codes> selectAll();

    Codes select(Codes criteria);

    Codes insert(Codes record);

    int update(Codes record);

    int delete(Codes record);
}
