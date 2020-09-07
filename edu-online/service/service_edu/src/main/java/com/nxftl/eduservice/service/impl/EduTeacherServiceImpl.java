package com.nxftl.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nxftl.commonutils.result.PageResult;
import com.nxftl.eduservice.entity.EduTeacher;
import com.nxftl.eduservice.entity.vo.TeacherQuery;
import com.nxftl.eduservice.mapper.EduTeacherMapper;
import com.nxftl.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author darkltl
 * @since 2020-08-28
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

	@Autowired
	EduTeacherMapper eduTeacherMapper;

	@Override
	public PageResult getTeacherList() {
		List<EduTeacher> eduTeachers = eduTeacherMapper.selectList(null);
		PageResult pageResult = new PageResult();
		pageResult.setTotal((long)eduTeachers.size()).setData(eduTeachers);
		return pageResult;
	}

	@Override
	public PageResult getTeacherByParam(@NonNull TeacherQuery query) {
		LambdaQueryWrapper<EduTeacher> wrapper = new LambdaQueryWrapper<>();
		String teacherName = query.getTeacherName();
		Integer level = query.getLevel();
		String begin = query.getBegin();
		String end = query.getEnd();
		@NotNull(message = "当前页不能为空") Integer thisPage = query.getThisPage();
		@NotNull(message = "所需条数不能为空") Integer pageNum = query.getPageNum();
		if(StringUtils.isNotBlank(teacherName)){
			wrapper.like(EduTeacher::getName,teacherName);
		}
		if(null!=level){
			wrapper.eq(EduTeacher::getLevel,level);
		}
		if(StringUtils.isNotBlank(begin)){
			wrapper.ge(EduTeacher::getGmtCreate,begin);
		}
		if(StringUtils.isNotBlank(end)){
			wrapper.le(EduTeacher::getGmtCreate,end);
		}
		Page<EduTeacher> page = new Page<>(thisPage,pageNum);
		IPage<EduTeacher> eduTeacherIPage = eduTeacherMapper.selectPage(page, wrapper);
		PageResult pageResult = new PageResult();
		pageResult.setTotal(eduTeacherIPage.getTotal());
		pageResult.setData(eduTeacherIPage.getRecords());
		return pageResult;
	}

	@Override
	public PageResult getTeacher(Integer teacherId) {
		EduTeacher eduTeacher = eduTeacherMapper.selectById(teacherId);
		PageResult pageResult = new PageResult();
		pageResult.setData(eduTeacher);
		return pageResult;
	}

	@Override
	public boolean deleteTeacher(Integer teacherId) {
		int i = eduTeacherMapper.deleteById(teacherId);
		return i>0?true:false;
	}
}
