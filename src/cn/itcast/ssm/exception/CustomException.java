package cn.itcast.ssm.exception; 
/** 
 * @ClassName: CustomException 
 * @Description: ϵͳ�Զ����쳣�����Ԥ�ڵ��쳣����Ҫ�ڳ������׳�������쳣 
 * @author A18ccms a18ccms_gmail_com 
 * @date 2017-8-2 ����10:17:58 
 */
public class CustomException extends Exception {
	
	//�쳣��Ϣ
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
 