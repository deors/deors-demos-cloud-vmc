package deors.demos.cloud.vmc.entities;

import java.io.Serializable;

public interface Codes
    extends Serializable {

    String getCode();

    void setCode(String code);

    String getValue();

    void setValue(String value);
}
