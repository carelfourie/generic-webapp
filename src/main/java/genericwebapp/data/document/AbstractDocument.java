package genericwebapp.data.document;

import org.springframework.data.annotation.Id;

public abstract class AbstractDocument {

    @Id
    protected String id;

}
