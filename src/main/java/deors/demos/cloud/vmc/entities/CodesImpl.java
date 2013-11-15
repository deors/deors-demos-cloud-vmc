package deors.demos.cloud.vmc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CODES")
public class CodesImpl
    implements Codes {

    private static final long serialVersionUID = 1L;

    private String code;

    private String value;

    public CodesImpl() {

        super();
    }

    @Id
    @Column(name="CODE")
    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    @Column(name="VALUE")
    public String getValue() {

        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }
}
