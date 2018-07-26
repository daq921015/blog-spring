package top.smartpos.blog.mappers.extend;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * 封装通用Mapper扩展自己的通用方法
 *
 * @param <T>
 */
@RegisterMapper
public interface ExtendMapper<T> extends Mapper<T>, MySqlMapper<T> {
    /**
     * 批量插入忽略唯一值
     *
     * @param recordList
     * @return
     */
    @Options(useGeneratedKeys = true)
    @InsertProvider(type = ExtendSelectProvider.class, method = "dynamicSQL")
    int insertIgnoreList(List<T> recordList);

    /**
     * 插入忽略唯一值
     *
     * @param record
     * @return
     */
    @InsertProvider(type = ExtendSelectProvider.class, method = "dynamicSQL")
    int insertIgnore(T record);
}
