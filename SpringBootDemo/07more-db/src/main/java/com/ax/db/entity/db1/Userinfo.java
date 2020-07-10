package com.ax.db.entity.db1;


import java.util.List;

/**
 * @author axing
 */
public class Userinfo  {


    private Long id;
    private String token;
    private String password;
    private String username;
    private int userType;

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    /**
     * 用户权限
     **/
    List<UserRole> authorities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserRole> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<UserRole> authorities) {
        this.authorities = authorities;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"token\":\"")
                .append(token).append('\"');
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append(",\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"authorities\":")
                .append(authorities);
        sb.append('}');
        return sb.toString();
    }
}
