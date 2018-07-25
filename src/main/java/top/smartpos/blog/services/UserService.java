package top.smartpos.blog.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.smartpos.blog.beans.domains.UserDomain;
import top.smartpos.blog.beans.models.UserModel;
import top.smartpos.blog.mappers.UserMapper;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = true)
    public List<UserDomain> list() {
//        Page<Object> page = PageHelper.startPage(pageNumber, pageSize, false);
        return userMapper.selectAll();
    }

    @Transactional(readOnly = true)
    public UserDomain findById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public long saveOrUpdate(UserModel userModel) {
        UserDomain userDomain = new UserDomain();
        BeanUtils.copyProperties(userModel, userDomain);
        if (userModel.getId() == null || userModel.getId() <= 0) {
            return userMapper.insertSelective(userDomain);
        }
        return userMapper.updateByPrimaryKeySelective(userDomain);
    }

    @Transactional
    public long update(int id, String name) {
        return userMapper.updateByPrimaryKeySelective(new UserDomain.Builder().id(id).name(name).build());
    }

    @Transactional
    public long delete(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
