package cn.itcast.ssm.exception; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/** 
 * @ClassName: CustomExceptionResolver 
 * @Description: ȫ���쳣������ 
 * @author A18ccms a18ccms_gmail_com 
 * @date 2017-8-2 ����10:27:26 
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		// handler���Ǵ�����������Ҫִ��Handler����ֻ��method��
		
		CustomException customException=null;
		if(ex instanceof CustomException){
			customException=(CustomException)ex;
		}
		else{
			customException=new CustomException("δ֪����");
		}
		//������Ϣ
		String message=customException.getMessage();
		
		ModelAndView modelAndView=new ModelAndView();
		
		//��������Ϣ����ҳ��
		modelAndView.addObject("message",message);
		
		//ָ�����ҳ��
		modelAndView.setViewName("error");
		
		return modelAndView;
	}

}
 