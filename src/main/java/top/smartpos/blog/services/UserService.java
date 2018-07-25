package top.smartpos.blog.services;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.smartpos.blog.beans.domains.UserDomain;
import top.smartpos.blog.mappers.UserMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = true)
    public List<UserDomain> list(int pageNumber, int pageSize) {
//        Page<Object> page = PageHelper.startPage(pageNumber, pageSize, false);
        return userMapper.selectAll();
    }

    @Transactional(readOnly = true)
    public UserDomain findById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public long save(String name, String email) {
        UserDomain userDomain1 = new UserDomain.Builder().name("ww").email("ww@163.com").build();
//        List<UserDomain> list = new ArrayList<>();
//        list.add(userDomain1);
        long la = userMapper.insertIgnore(userDomain1);
        System.out.println(userDomain1.getId());
        return la;
        //        return userMapper.insertSelective(new UserDomain.Builder().name(name).email(email).build());
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
