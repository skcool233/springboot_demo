package com.sunkai.springboot_demo.pojo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserDto {
    private Integer userId;
    @NotBlank(message = "用户名不能为空")    //去除空格
    //@NotEmpty   不能为双引号
    private String userName;
    @NotBlank(message = "用户名不能为空")
    @Length(min = 6, max = 12)
    private String password;
    @Email(message = "邮箱格式错误")
    private String email;


//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    @Override
    public String toString() {
        return "UserDto{"+
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
