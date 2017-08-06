package cn.itcast.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: HandlerInterceptor1
 * @Description: 登陆拦截器
 * @author A18ccms a18ccms_gmail_com
 * @date 2017-8-6 上午10:35:43
 */
public class LoginInterceptor implements HandlerInterceptor {

	// 进入Handler方法之前执行
	// 用于身份认证、身份授权
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		
		//获取请求的url
		String url=request.getRequestURL().toString();
		//判断url是否是公开地址（实际使用时将公开地址配置到配置文件中）
		//这里公开地址是登录提交的地址
		if(url.indexOf("login.action")>=0){
			//如果进行登录提交，放行
			return true;
		}
		
		//判断session
		HttpSession session=request.getSession();
		//从session中取出用户身份信息
		String username=(String) session.getAttribute("username");
		
		if(username!=null){
			//身份存在，放行
			return true;
		}
		
		//执行这里表示用户身份需要认证，跳转登录页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);		
		
		return false;
	}
	
	// 执行Handler完成执行此方法
	// 应用场景：统一异常处理、统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("HandlerInterceptor1...afterCompletion");
	}

	// 进入Handler方法之后，返回modelAndView之前执行
	// 应用场景从modelAndView出发：将公用的模型数据（比如菜单导航）在这里传到视图，也可以在这里统一指定视图
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("HandlerInterceptor1...postHandle");

	}



}
