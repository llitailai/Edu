package com.nxftl.eduservice.mapper;

import com.nxftl.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 讲师 Mapper 接口
 * </p>
 *
 * @author darkltl
 * @since 2020-08-28
 */
@Mapper
@Repository
public interface EduTeacherMapper extends BaseMapper<EduTeacher> {

}
