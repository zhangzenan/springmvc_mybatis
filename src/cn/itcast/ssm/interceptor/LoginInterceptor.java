package cn.itcast.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: HandlerInterceptor1
 * @Description: ��½������
 * @author A18ccms a18ccms_gmail_com
 * @date 2017-8-6 ����10:35:43
 */
public class LoginInterceptor implements HandlerInterceptor {

	// ����Handler����֮ǰִ��
	// ���������֤�������Ȩ
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		
		//��ȡ�����url
		String url=request.getRequestURL().toString();
		//�ж�url�Ƿ��ǹ�����ַ��ʵ��ʹ��ʱ��������ַ���õ������ļ��У�
		//���﹫����ַ�ǵ�¼�ύ�ĵ�ַ
		if(url.indexOf("login.action")>=0){
			//������е�¼�ύ������
			return true;
		}
		
		//�ж�session
		HttpSession session=request.getSession();
		//��session��ȡ���û������Ϣ
		String username=(String) session.getAttribute("username");
		
		if(username!=null){
			//��ݴ��ڣ�����
			return true;
		}
		
		//ִ�������ʾ�û������Ҫ��֤����ת��¼ҳ��
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);		
		
		return false;
	}
	
	// ִ��Handler���ִ�д˷���
	// Ӧ�ó�����ͳһ�쳣����ͳһ��־����
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
