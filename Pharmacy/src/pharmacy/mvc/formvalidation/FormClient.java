package pharmacy.mvc.formvalidation;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import pharmacy.entity.Client;
import pharmacy.entity.User;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class FormClient {

    private Client client;

    private User user;

    private String password;

    private Long[] rid;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long[] getRid() {
        return rid;
    }

    public void setRid(Long[] rid) {
        this.rid = rid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FormClient() {
    }

    public FormClient(Client client) {
        this.client = client;
    }

    public void clear() {
        password = null;
        client = null;
        rid = null;
    }
}
