package cn.itcast.ssm.interceptor; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/** 
 * @ClassName: HandlerInterceptor2
 * @Description: 测试拦截器2
 * @author A18ccms a18ccms_gmail_com 
 * @date 2017-8-6 上午10:35:43 
 */
public class HandlerInterceptor2 implements HandlerInterceptor {

	//进入Handler方法之前执行
	//用于身份认证、身份授权
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {		
		System.out.println("HandlerInterceptor2...afterCompletion");		
	}

	//进入Handler方法之后，返回modelAndView之前执行
	//应用场景从modelAndView出发：将公用的模型数据（比如菜单导航）在这里传到视图，也可以在这里统一指定视图
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("HandlerInterceptor2...postHandle");
		
	}

	//执行Handler完成执行此方法
	//应用场景：统一异常处理、统一日志处理
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("HandlerInterceptor2...postHandle");
		return true;
	}

}
 