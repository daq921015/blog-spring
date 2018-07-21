package top.smartpos.blog.mappers;

import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import top.smartpos.blog.beans.domains.CountryDomain;

@Component
public interface CountryMapper extends Mapper<CountryDomain> {
}
