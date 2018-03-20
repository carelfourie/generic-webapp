package genericwebapp.data.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User extends AbstractDocument {
}
