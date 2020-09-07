package com.nxftl.eduservice.service;

import com.nxftl.commonutils.result.PageResult;
import com.nxftl.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nxftl.eduservice.entity.vo.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author darkltl
 * @since 2020-08-28
 */
public interface EduTeacherService extends IService<EduTeacher> {

	/**
	 * 获取所有讲师
	 * @return
	 */
	public PageResult getTeacherList();


	/**
	 * 根据条件查询讲师,携带分页
	 * 该方法可只做分页查询,可做分页条件查询
	 * @param query
	 * @return
	 */
	public PageResult getTeacherByParam(TeacherQuery query);

	/**
	 * 获取指定ID的教师
	 * @param teacherId
	 * @return
	 */
	public PageResult getTeacher(Integer teacherId);

	/**
	 * 删除指定教师
	 * @param teacherId
	 */
	public boolean deleteTeacher(Integer teacherId);
}
