package cn.com.deepdata.frontend.entity;

import io.dropwizard.jackson.JsonSnakeCase;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * Created by neyao@github.com on 2016/3/30.

 */
@SuppressWarnings("ALL")
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(
                name = "cn.com.deepdata.front.entity.User.findAll",
                query = "select u from User u"
        )
})
@JsonSnakeCase
public class User {


    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private int id;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "email")
    private String email;

    @Size(min=2,max=10)
    @Column(name = "qq")
    private String qq;

    @NotEmpty
    @Column(name = "weixin")
    private String weixin;

    @Min(2)
    @Max(3)
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public User() {
        // neccessay for json deserialization
    }
}
