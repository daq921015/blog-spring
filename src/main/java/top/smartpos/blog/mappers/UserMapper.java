package top.smartpos.blog.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import top.smartpos.blog.beans.domains.UserDomain;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    List<UserDomain> list();

    UserDomain findById(@Param("id") int id);

    long save(@Param("name") String name, @Param("email") String email);

    long update(@Param("id") int id, @Param("name") String name);

    long delete(@Param("id") int id);
}
