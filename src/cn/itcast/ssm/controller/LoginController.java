package cn.itcast.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: LoginController
 * @Description: 登录
 * @author A18ccms a18ccms_gmail_com
 * @date 2017-8-6 下午9:45:45
 */
@Controller
public class LoginController {

	// 登录
	@RequestMapping("/login")
	public String login(HttpSession session, String username, String password)
			throws Exception {
		// 调用service进行身份认证

		// 在session中保存用户身份信息
		session.setAttribute("username", username);

		// 重定向到商品列表页面
		return "redirect:/items/queryItems.action";
	}

	//退出
	@RequestMapping("/logout")	
	public String logout(HttpSession session) throws Exception {
		//清除session
		session.invalidate();
		
		// 重定向到商品列表页面
		return "redirect:/items/queryItems.action";
	}

}
