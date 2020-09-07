package com.nxftl.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
public class TeacherQuery {
	@ApiModelProperty("教师名称,模糊查询")
	private String teacherName;

	@ApiModelProperty("头衔 高级讲师,首席讲师")
	private Integer level;

	@ApiModelProperty(value = "查询开始时间",example = "2019-01-01 10:10:10")
	private String begin;

	@ApiModelProperty(value = "查询结束时间",example = "2019-12-01 10:10:10")
	private String end;

	@ApiModelProperty(value = "当前页",example = "1")
	@NotNull(message = "当前页不能为空")
	private Integer thisPage;


	@ApiModelProperty(value = "所需条数",example = "10")
	@NotNull(message = "所需条数不能为空")
	private Integer pageNum;
}
