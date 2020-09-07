package com.nxftl.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nxftl.commonutils.result.PageResult;
import com.nxftl.commonutils.result.Res;
import com.nxftl.eduservice.entity.EduTeacher;
import com.nxftl.eduservice.entity.vo.TeacherQuery;
import com.nxftl.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author darkltl
 * @since 2020-08-28
 */
@Api("讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
	@Autowired
	private EduTeacherService eduTeacherService;

	@GetMapping("/getTeacherAll")
	public Res getTeachers(){
		PageResult teacherList = eduTeacherService.getTeacherList();
		return Res.success(teacherList);
	}


	@PostMapping("/getTeacherByParam")
	public Res getTeachersByParam(@NonNull @RequestBody TeacherQuery teacherQuery){
		PageResult teacherByParam = eduTeacherService.getTeacherByParam(teacherQuery);
		return Res.success(teacherByParam);
	}
	@GetMapping("/getTeacher/{id}")
	public Res getTeacher(@NonNull @PathVariable Integer id){
		PageResult teacher = eduTeacherService.getTeacher(id);
		return Res.success(teacher);
	}

	@DeleteMapping("/deleteTeacher/{id}")
	public Res deleteTeacher(@NonNull @PathVariable Integer id){
		return eduTeacherService.deleteTeacher(id)?Res.success():Res.error();
	}

	@PostMapping("/addTeacher")
	public Res addTeacher(@RequestBody EduTeacher eduTeacher){
		return eduTeacherService.save(eduTeacher)?Res.success():Res.error();
	}

	@PostMapping("/updateTeacher")
	public Res updateTeacher(@RequestBody EduTeacher eduTeacher){
		return eduTeacherService.updateById(eduTeacher)?Res.success():Res.error();
	}
}

