package com.ax.demo.email;

public class EmailDto {


    @javax.validation.constraints.Email(message = "错误的邮箱格式")
    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"email\":\"")
                .append(email).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
