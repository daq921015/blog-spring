package top.smartpos.blog.beans.domains;

import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
public class UserDomain {
    @Id
    @KeySql(dialect = IdentityDialect.DEFAULT)
    private Integer id;
    private String name;
    private String email;

    public UserDomain() {
    }

    private UserDomain(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setEmail(builder.email);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static final class Builder {
        private int id;
        private String name;
        private String email;

        public Builder() {
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public UserDomain build() {
            return new UserDomain(this);
        }
    }
}
