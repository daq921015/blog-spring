package top.smartpos.blog.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import top.smartpos.blog.beans.domains.UserDomain;
import top.smartpos.blog.mappers.extend.ExtendMapper;

@Component
@Mapper
public interface UserMapper extends ExtendMapper<UserDomain> {
}
