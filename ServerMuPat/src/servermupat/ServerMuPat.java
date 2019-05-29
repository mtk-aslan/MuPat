/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermupat;

import interfacemupat.ServerInterface;
import interfacemupat.User;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Muttaki, Patrik & Patrick
 */
public class ServerMuPat extends UnicastRemoteObject implements ServerInterface {

    private MySQL db;
    private Hashtable<Integer, User> sessionstore;

    /**
     * In den folgenden Zeilen verbinden wir uns mit der Datenbank. Falls die
     * gewünschte Tabelle noch nicht existiert, wird diese noch erzeugt.
     */
    public ServerMuPat() throws RemoteException, SQLException, ClassNotFoundException {
        super();
        this.db = new MySQL("TEAM_6D_DB", "TEAM_6D", "gE8f6CAd");
        //this.db = new MySQL("mupat", "Paddy", "Pirat");
        this.sessionstore = new Hashtable<>();
        this.db.execute("create table if not exists user(id int auto_increment, first_name varchar (32) not null, last_name varchar (32) not null, nickname varchar (32) not null, email_address varchar(32) not null, password varchar(32) not null, primary key (id), unique key (nickname)) engine = innodb default charset = utf8");
        this.db.execute("create table if not exists friend(userid integer, friendid integer, primary key(userid, friendid), foreign key(userid) references user(id) on delete cascade, foreign key(friendid) references user(id) on delete cascade) engine=innodb;");
    }

    public static void main(String[] args) {
        /**
         * Die folgenden Zeilen sind komplett aus dem RMI Beispiel entnommen. Es
         * wird eineRegistry erzeugt und zum Schluss geben wir uns die
         * Möglichkeit die Serverausführung zu beenden.
         */
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Naming.rebind("rmi://127.0.0.1/Server", new ServerMuPat());
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(ServerMuPat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerMuPat.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Press Enter to terminate the Server");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.exit(0);

    }

    /**
     * Nun kommen unsere implementierten Methoden aus unserem Interface. In
     * "createAccount" werden die einzugebenen Informationen in der Datenbank
     * abgespeichert (Passwort mit md5() Funktion verschlüsselt).
     */
    @Override
    public boolean createAccount(User user) throws RemoteException {
        try {
            this.db.execute("insert into user (first_name, last_name, email_address, password, nickname) values (?, ?, ?, md5(?), ?)", user.getFirst(), user.getName(), user.getEmail(), user.getPassword(), user.getNick());
        } catch (SQLException ex) {
            Logger.getLogger(ServerMuPat.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * In "login" sorgen wir dafür, dass der Benutzer nur dann Zugang erhält,
     * wenn der Nickname und das Passwort zusammen übereinstimmen. Zusätzlich
     * geben wir eine "Session ID" zurück.
     */
    @Override
    public int login(String username, String password) throws RemoteException {

        try {
            ResultSet rs = this.db.executeQuery("select * from user where nickname = ? and password = md5(?)", username, password);
            if (rs.next()) {

                int sessionid = (int) Math.ceil(Math.random() * 987654321);
                sessionstore.put(sessionid, new User(rs.getInt("id"), rs.getString("nickname"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email_address"), null));
                String s = sessionid + " " + username;
                System.out.println(s);
                return sessionid;

            }
        } catch (SQLException ex) {
            Logger.getLogger(ServerMuPat.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    @Override
    public boolean logout(int sessionid) throws RemoteException {
        return sessionstore.remove(sessionid) != null;

    }

    @Override
    public boolean addFriend(int session, User friend) throws RemoteException {
        try {
            this.db.execute("insert into friend (userid, friendid) values (?, ?)", sessionstore.get(session).getId(), friend.getId());

        } catch (SQLException ex) {

            Logger.getLogger(ServerMuPat.class.getName()).log(Level.SEVERE, null, ex);

            return false;

        }
        return true;

    }

    @Override
    public int checkSessionid(int sessionid) throws RemoteException {

        System.out.println(sessionid);
        return sessionid;
    }

    @Override
    public int showUserid(int sessionid) throws RemoteException {
        int userid = sessionstore.get(sessionid).getId();

        return userid;

    }

    @Override
    public List<User> searchUsers(int sessionid, String search) throws RemoteException {
        try {
            ResultSet su = this.db.executeQuery("select * from user where lower(nickname) like concat(lower(?),'%') and id != ?", search, sessionstore.get(sessionid).getId());

            List<User> list = new ArrayList<User>();
            while (su.next()) {
                list.add(new User(su.getInt("id"), su.getString("nickname"), su.getString("first_name"), su.getString("last_name"), su.getString("email_address"), null));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ServerMuPat.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public List<User> getFriends(int sessionid) throws RemoteException {
        try {
            ResultSet su = this.db.executeQuery("select * from friend inner join user on friend.friendid = user.id where friend.userid = ?", sessionstore.get(sessionid).getId());

            List<User> list = new ArrayList<User>();
            while (su.next()) {
                list.add(new User(su.getInt("id"), su.getString("nickname"), su.getString("first_name"), su.getString("last_name"), su.getString("email_address"), null));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ServerMuPat.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public boolean removeFriend(int session, User friend) throws RemoteException {
        try {
            this.db.execute("delete from friend where userid = ? and friendid = ?", sessionstore.get(session).getId(), friend.getId()); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ServerMuPat.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public int getFriendsCount(int sessionid) throws RemoteException {
        int userid = sessionstore.get(sessionid).getId();
        try {
            ResultSet cs = this.db.executeQuery("select count(*) as c from friend where userid = ? and friendid in (select userid from friend where friendid = ?)", userid, userid);
            if (cs.next()) {
                return cs.getInt("c");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServerMuPat.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    @Override
    public int getStalkerCount(int sessionid) throws RemoteException {
        int userid = sessionstore.get(sessionid).getId();
        try {
            ResultSet cs = this.db.executeQuery("select count(*) as c from friend where friendid = ? and userid not in (select friendid from friend where userid = ?)", userid, userid);
            if (cs.next()) {
                return cs.getInt("c");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServerMuPat.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    @Override
    public int getNotEvenFriendzoneCount(int sessionid) throws RemoteException {
        int userid = sessionstore.get(sessionid).getId();
        try {
            ResultSet cs = this.db.executeQuery("select count(*) as c from friend where userid = ? and friendid not in (select userid from friend where friendid = ?)", userid, userid);
            if (cs.next()) {
                return cs.getInt("c");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServerMuPat.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    @Override
    public User getUserdata(int sessionid) throws RemoteException {
        try {
//          

            // Variable hier wird vorübergehend mal festgelegt, später wird sie beim Login aber mitgeschickt
            int userid = sessionstore.get(sessionid).getId();
            // Hier formuliere ich meine SQL-Anfrage:
            String query = "SELECT * FROM user WHERE id =" + userid;

            // PreparedStatement-Instanz (Benutzt man bei Variablen im SQL-Code)
            // Statementinstanz:
            // Anfrage wird ausgeführt und ich erhalte ein ResultSet:
            ResultSet rs = db.executeQuery(query);
            String firstName = null;
            String lastName = null;
            String nickName = null;
            String emailAddress = null;
            String password = null;
            // Ich iteriere durch das komplette ResultSet:
            while (rs.next()) {
                int id = rs.getInt("id");
                firstName = rs.getString("first_name");
                lastName = rs.getString("last_name");
                nickName = rs.getString("nickname");
                emailAddress = rs.getString("email_address");
                password = rs.getString("password");
            }
            User user = new User(userid, nickName, firstName, lastName, emailAddress, password);
            return user;

        } catch (SQLException ex) {
            Logger.getLogger(ServerMuPat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public boolean setUserdata(int sessionid, User user) throws RemoteException {
      try {
            int userid = sessionstore.get(sessionid).getId();
            this.db.execute("UPDATE user SET first_name ="+user.getFirst()+", last_name ="+user.getName()+" WHERE id ="+userid);
        } catch (SQLException ex) {
            Logger.getLogger(ServerMuPat.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;   
    }
    

}
