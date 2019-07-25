package organization.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import organization.dao.UserMapper;
import organization.entity.param.UserQueryParam;
import organization.entity.po.User;
import organization.service.IUserService;

import java.util.List;

@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public long add(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userMapper.insert(user);
    }

    @Override
    @CacheEvict(value = "user", key = "#root.targetClass.name+'-'+#id")
    public void delete(long id) {
        userMapper.deleteById(id);
    }

    @Override
    @CacheEvict(value = "user", key = "#root.targetClass.name+'-'+#user.id")
    public void update(User user) {
        userMapper.updateById(user);
    }

    @Override
    @Cacheable(value = "user", key = "#root.targetClass.name+'-'+#id")
    public User get(long id) {
        return userMapper.selectById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
    }

    @Override
    public List<User> query(UserQueryParam userQueryParam) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge(null != userQueryParam.getCreatedTimeStart(), "created_time", userQueryParam.getCreatedTimeStart());
        queryWrapper.le(null != userQueryParam.getCreatedTimeEnd(), "created_time", userQueryParam.getCreatedTimeEnd());
        queryWrapper.eq(StringUtils.isNotBlank(userQueryParam.getName()), "name", userQueryParam.getName());
        queryWrapper.eq(StringUtils.isNotBlank(userQueryParam.getUsername()), "username", userQueryParam.getUsername());
        queryWrapper.eq(StringUtils.isNotBlank(userQueryParam.getMobile()), "mobile", userQueryParam.getMobile());
        return userMapper.selectList(queryWrapper);
    }
}
