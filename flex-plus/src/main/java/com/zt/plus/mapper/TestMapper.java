package com.zt.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zt.plus.domain.Test;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper extends BaseMapper<Test> {
    int deleteByPrimaryKey(Long id);
}