package car2.model.master;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Lookup {
    @Id
    private UUID id;

    private UUID refParent;

    private String group;

    private String key;

    private String value;

    private String value2;

    private Integer seq;

}
