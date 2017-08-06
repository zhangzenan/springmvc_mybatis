package cn.itcast.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: LoginController
 * @Description: ��¼
 * @author A18ccms a18ccms_gmail_com
 * @date 2017-8-6 ����9:45:45
 */
@Controller
public class LoginController {

	// ��¼
	@RequestMapping("/login")
	public String login(HttpSession session, String username, String password)
			throws Exception {
		// ����service���������֤

		// ��session�б����û������Ϣ
		session.setAttribute("username", username);

		// �ض�����Ʒ�б�ҳ��
		return "redirect:/items/queryItems.action";
	}

	//�˳�
	@RequestMapping("/logout")	
	public String logout(HttpSession session) throws Exception {
		//���session
		session.invalidate();
		
		// �ض�����Ʒ�б�ҳ��
		return "redirect:/items/queryItems.action";
	}

}
