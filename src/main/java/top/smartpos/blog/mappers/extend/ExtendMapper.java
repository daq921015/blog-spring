package top.smartpos.blog.mappers.extend;

import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * 封装通用Mapper扩展自己的通用方法
 *
 * @param <T>
 */
@RegisterMapper
public interface ExtendMapper<T> extends Mapper<T> {
    @SelectProvider(type = ExtendSelectProvider.class, method = "dynamicSQL")
    T selectOneTest(T record);
}
