package interfacemupat;

import java.io.Serializable;

/**
 *
 * @author Muttaki, Patrik & Patrick
 */
/**
 *
 * Hier erstellen wir die Klasse "User", um die jeweiigen Attribute später
 * verwenden zu können.
 */
public class User implements Serializable {
    
    private int id;
    private String nick;
    private String first;
    private String name;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public String getFirst() {
        return first;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User(int id, String nick, String first, String name, String email, String password) {
        this.id = id;
        this.nick = nick;
        this.first = first;
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
