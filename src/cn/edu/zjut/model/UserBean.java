package cn.edu.zjut.model;

/**
 * Created by a on 2017/10/10.
 */
public class UserBean {
    private String username; //账号
    private String password; //密码
    private String type; //用户类型

    //默认构造函数
    public UserBean() {
    }

    //setter和getter方法
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
