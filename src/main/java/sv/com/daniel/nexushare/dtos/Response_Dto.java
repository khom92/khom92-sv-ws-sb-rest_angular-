package sv.com.daniel.nexushare.dtos;

import sv.com.daniel.nexushare.interfaces.IResponseDto;

public class Response_Dto <T>  implements IResponseDto<T> {

	private String responseCode;
	private T value;
	private String message;
	
	public Response_Dto(){}
	
	public Response_Dto(String code, T value){
		this.responseCode = code;
		this.value=value;
	}
	
	public Response_Dto(String code){
		this.responseCode = code;
	}
	
	public Response_Dto(String responseCode, T value,String message){
		this.responseCode = responseCode;
		this.value=value;
		this.setMessage(message);
	}

	public String getResponseCode() {
		return responseCode;
	}
	
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}