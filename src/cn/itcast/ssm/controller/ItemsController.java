package cn.itcast.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.service.ItemsService;

/**
 * @ClassName: ItemsController
 * @Description: ��ƷController
 * @author A18ccms a18ccms_gmail_com
 * @date 2017-7-23 ����12:49:37
 */

@Controller
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	// ��Ʒ��ѯ�б�
	// @RequestMappingʵ�ֶ�queryItems������url����ӳ�䣬һ��������Ӧһ��url
	// һ�㽨�齫url�ͷ���д��һ��
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception {

		List<ItemsCustom> itemsList = itemsService.findItemsList(null);	

		// ����ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// �൱��request��setAttribut,��jspҳ����ͨ��itemsListȡ����
		modelAndView.addObject("itemsList", itemsList);

		// ָ����ͼ
		// �±ߵ�·�����������ͼ������������jsp·����ǰ׺��jsp�ĺ�׺���޸�Ϊ
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		modelAndView.setViewName("items/itemsList");

		return modelAndView;
	}

}
