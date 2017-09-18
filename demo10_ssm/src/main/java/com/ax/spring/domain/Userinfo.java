package com.ax.spring.domain;

public class Userinfo {


    public static final int USERTYPE_NORMAL;

    static {
        USERTYPE_NORMAL = 0;
    }

    public static final int USERTYPE_SYSTEM;

    static {
        USERTYPE_SYSTEM = 1;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_userinfo.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_userinfo.username
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_userinfo.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_userinfo.userType
     *
     * @mbggenerated
     */
    private Integer usertype;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_userinfo.id
     *
     * @return the value of t_userinfo.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_userinfo.id
     *
     * @param id the value for t_userinfo.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_userinfo.username
     *
     * @return the value of t_userinfo.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_userinfo.username
     *
     * @param username the value for t_userinfo.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_userinfo.password
     *
     * @return the value of t_userinfo.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_userinfo.password
     *
     * @param password the value for t_userinfo.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_userinfo.userType
     *
     * @return the value of t_userinfo.userType
     *
     * @mbggenerated
     */
    public Integer getUsertype() {
        return usertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_userinfo.userType
     *
     * @param usertype the value for t_userinfo.userType
     *
     * @mbggenerated
     */
    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", usertype=" + usertype +
                '}';
    }
}