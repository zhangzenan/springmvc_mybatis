package cn.itcast.ssm.interceptor; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/** 
 * @ClassName: HandlerInterceptor1 
 * @Description: ����������1
 * @author A18ccms a18ccms_gmail_com 
 * @date 2017-8-6 ����10:35:43 
 */
public class HandlerInterceptor1 implements HandlerInterceptor {

	// ����Handler����֮ǰִ��
	// ����������֤��������Ȩ
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("HandlerInterceptor1...postHandle");
		return true;
	}
	
	// ִ��Handler���ִ�д˷���
	// Ӧ�ó�����ͳһ�쳣������ͳһ��־����
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("HandlerInterceptor1...afterCompletion");
	}

	// ����Handler����֮�󣬷���modelAndView֮ǰִ��
	// Ӧ�ó�����modelAndView�����������õ�ģ�����ݣ�����˵������������ﴫ����ͼ��Ҳ����������ͳһָ����ͼ
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("HandlerInterceptor1...postHandle");

	}
}
 