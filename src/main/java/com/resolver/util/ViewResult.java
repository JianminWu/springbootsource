package com.resolver.util;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ViewResult implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** 数据 */
	private Object data;
	
	/**
	 * 处理结果
	 */
	private boolean success;
	
	/**
	 * 状态码
	 */
	private String code;
	
	/**
	 * 返回消息
	 */
	private String message;
	

	/**
	 * 设置数据。
	 * @param data 数据。
	 */
	public void setData(Object data) {
		this.data = data;
	}

	public ViewResult data(Object data){
		this.data=data;
		return this;
	}
	

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
	public static ViewResult from(SingleResult result) {
		ViewResult viewResultInfo = new ViewResult();
		viewResultInfo.setMessage(result.getMessage());
		viewResultInfo.setSuccess(result.getStatus() == ResultStatus.SUCCESS);
		viewResultInfo.setData(result.getData());
		viewResultInfo.setCode(result.getCode());
		return viewResultInfo;
	}
	public static ViewResult from(Object data) {
		ViewResult viewResultInfo = new ViewResult();
		viewResultInfo.setSuccess(true);
		viewResultInfo.setData(data);
		return viewResultInfo;
	}
}
