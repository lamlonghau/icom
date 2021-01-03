package com.icommerce.shopcard.delivery.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> implements Serializable {

	private String status;
	private String code;
	private String message;
	private T data;

	public BaseResponse() {
		super();
	}

	public BaseResponse(String status, String code) {
		this.status = status;
		this.code = code;
	}

	public BaseResponse(String status, String code, T data) {
		this.status = status;
		this.code = code;
		this.data = data;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
