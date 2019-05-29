
import interfacemupat.User;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Paddy
 */
public class UserListModel implements ListModel<String>{

    private List<User> users;
    
    public UserListModel(List<User> users) {
        this.users = users;
    }
    
    @Override
    public int getSize() {
        return users.size();
    }

    public User getUserAt(int index) {
        return users.get(index);
    }
    
    @Override
    public String getElementAt(int index) {
        return users.get(index).getNick();
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }
    
}
