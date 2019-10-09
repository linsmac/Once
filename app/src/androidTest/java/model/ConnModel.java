package model;

public class ConnModel {
    int username,password;
    String email;

    public ConnModel(int u,int p,String e){
        this.username = u;
        this.password = p;
        this.email = e;
    }


    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
