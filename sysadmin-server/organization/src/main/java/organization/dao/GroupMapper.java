package organization.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import organization.entity.po.Group;

@Repository
@Mapper
public interface GroupMapper extends BaseMapper<Group> {
}