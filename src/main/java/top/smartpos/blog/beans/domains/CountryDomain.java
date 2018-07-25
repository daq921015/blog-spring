package top.smartpos.blog.beans.domains;

import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "country")
public class CountryDomain {
    @Id
    @KeySql(dialect = IdentityDialect.DEFAULT)
    private Integer id;
    private String countryName;
    private String countryCode;
    private String addr;

    public CountryDomain() {
    }

    private CountryDomain(Builder builder) {
        setId(builder.id);
        setCountryName(builder.countryName);
        setCountryCode(builder.countryCode);
        setAddr(builder.addr);
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public static final class Builder {
        private Integer id;
        private String countryName;
        private String countryCode;
        private String addr;

        public Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder countryName(String val) {
            countryName = val;
            return this;
        }

        public Builder countryCode(String val) {
            countryCode = val;
            return this;
        }

        public Builder addr(String val) {
            addr = val;
            return this;
        }

        public CountryDomain build() {
            return new CountryDomain(this);
        }
    }
}
