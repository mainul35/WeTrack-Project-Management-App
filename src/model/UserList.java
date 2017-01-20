package model;

import java.util.ArrayList;

public class UserList {

    private ArrayList<User> users;
    public volatile static UserList userList;
    private UserList(){

    }

    public static UserList getUserList() {
        if(userList!=null){
            throw new RuntimeException("Singleton can't create UserList. Please use getUserList()");
        }else {
            synchronized (UserList.class) {
                if(userList==null){
                    userList = new UserList();
                }
            }
        }
        return UserList.userList;
    }

    public void addAll(ArrayList<User> userList){
        this.users = userList;
    }
    
    public ArrayList<User> getAll(){
        return this.users;
    }
    
    public User get(int i){
        return this.users.get(i);
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    private Object readResolve(){
        return UserList.getUserList();
    }
}
