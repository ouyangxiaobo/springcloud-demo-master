package organization.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import organization.entity.po.Menu;

@Repository
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
}