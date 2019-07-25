package organization.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import organization.entity.po.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PositionMapper extends BaseMapper<Position> {
}