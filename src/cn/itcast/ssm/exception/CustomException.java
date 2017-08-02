package cn.itcast.ssm.exception; 
/** 
 * @ClassName: CustomException 
 * @Description: 系统自定义异常，针对预期的异常，需要在程序中抛出此类的异常 
 * @author A18ccms a18ccms_gmail_com 
 * @date 2017-8-2 下午10:17:58 
 */
public class CustomException extends Exception {
	
	//异常信息
	public String message;
	
	public CustomException(String message){
		super(message);
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
 