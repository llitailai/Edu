package com.nxftl.commonutils.result;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class PageResult<T> {

	private Long total;

	private T data;
}
