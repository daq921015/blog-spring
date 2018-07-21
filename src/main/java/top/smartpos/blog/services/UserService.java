package top.smartpos.blog.services;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.smartpos.blog.beans.domains.UserDomain;
import top.smartpos.blog.mappers.UserMapper;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserDomain> list(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize, true);
        return userMapper.list();
    }

    public UserDomain findById(int id) {
        return userMapper.findById(id);
    }

    public long save(String name, String email) {
        return userMapper.save(name, email);
    }

    public long update(int id, String name) {
        return userMapper.update(id, name);
    }

    public long delete(int id) {
        return userMapper.delete(id);
    }
}
