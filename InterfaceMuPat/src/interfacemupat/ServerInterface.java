package interfacemupat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Muttaki, Patrik & Patrick
 */
/**
 * Dies ist unser Interface (gerichtet nach dem RMI-Beispiel). Dieses beinhaltet
 * die folgenden Methoden für die Kommunikation zwischen Client und Server.
 *
 */
public interface ServerInterface extends Remote {

    public int login(String username, String password) throws RemoteException; // Verbindung herstellen

    public boolean logout(int sessionid) throws RemoteException; // Verbindung trennen

    public boolean createAccount(User user) throws RemoteException; // Account erstellen

    public boolean addFriend(int session, User friend) throws RemoteException;
    
    public boolean removeFriend(int session, User friend) throws RemoteException;

    public int checkSessionid(int sessionid) throws RemoteException;
    
    public int showUserid(int sessionid) throws RemoteException;
    
    public List<User> searchUsers(int sessionid, String search) throws RemoteException;
    
    public List<User> getFriends(int sessionid) throws RemoteException;
    
    public int getFriendsCount(int sessionid) throws RemoteException;
            
    public int getStalkerCount(int sessionid) throws RemoteException;
            
    public int getNotEvenFriendzoneCount(int sessionid) throws RemoteException;
    
    public User getUserdata(int sessionid) throws RemoteException;
    
    public boolean setUserdata(int sessionid, User user) throws RemoteException;
            
    

}
