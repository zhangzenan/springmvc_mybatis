package cn.itcast.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.controller.validation.ValidGroup1;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;

/**
 * @ClassName: ItemsController
 * @Description: ��ƷController
 * @author A18ccms a18ccms_gmail_com
 * @date 2017-7-23 ����12:49:37
 */

@Controller
//Ϊ�˶�url���з���������������ﶨ���·�������շ��ʵ�url�Ǹ�·��+��·��
//���磺��Ʒ�б�/items
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;
	
	//��Ʒ����
	//itemtypes��ʾ���ս���������ֵ����request�е�key
	@ModelAttribute("itemtypes")
	public Map<String,String> getItemTypes(){
		Map<String,String> itemTypes=new HashMap<String,String>();
		itemTypes.put("101","����");
		itemTypes.put("102","ĸӤ");
		return itemTypes;
	}

	// ��Ʒ��ѯ�б�
	// @RequestMappingʵ�ֶ�queryItems������url����ӳ�䣬һ��������Ӧһ��url
	// һ�㽨�齫url�ͷ���д��һ��
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception {

		//����forward��request�Ƿ���Թ���
		
		System.out.println(request.getParameter("id"));
		
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

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

	/**
	 * @Title: editItems
	 * @Description: ��Ʒ��Ϣ�޸�ҳ����ʾ
	 * @param @return
	 * @param @throws Exception �趨�ļ�
	 * @return ModelAndView ��������
	 * @throws
	 */
	//@RequestMapping("/editItems")
	//����http���󷽷�������post��get	
/*	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView editItems() throws Exception {

		// ����service������Ʒid��ѯ��Ʒ��Ϣ
		ItemsCustom itemsCustom = itemsService.findItemsById(1);

		// ����ModelAndView
		ModelAndView modelAndView = new ModelAndView();

		// ����Ʒ��Ϣ�ŵ�model
		modelAndView.addObject("itemsCustom", itemsCustom);

		// ��Ʒ�޸�ҳ��
		modelAndView.setViewName("items/editItems");

		return modelAndView;
	}*/
	
	//����String
	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
	//�����ʹ��@RequestParam��request����Ĳ������Ʊ�����βεĲ�������һ��
	//@RequestParam���ָ��request����������βν��а�
	//ͨ��required����ָ�������Ƿ����Ҫ����
	//ͨ��defaultValue��������Ĭ��ֵ�����id����û�д��룬��Ĭ��ֵ���βΰ�
	public String editItems(Model model,@RequestParam(value="id",required=true,defaultValue="1") Integer items_id) throws Exception {

		// ����service������Ʒid��ѯ��Ʒ��Ϣ
		ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
	
		//ͨ���β��е�model��model���ݴ���ҳ��
		//�൱��modelAndView.addObject����
		model.addAttribute("items",itemsCustom);

		return "items/editItems";
	}

	/**
	 * @Title: editItemsSubmit
	 * @Description: ��Ʒ��Ϣ�޸��ύ
	 * @param @return
	 * @param @throws Exception �趨�ļ�
	 * @return ModelAndView ��������
	 * @throws
	 */
	//����ҪУ���pojoǰ�����@Validated������ҪУ���pojo������BindingResult bindingResult����У��������Ϣ
	//ע�⣺@Validated��BindingResult bindingResult����Գ��֣������β�˳���ǹ̶��ģ�һǰһ��
	//value={ValidGroup1.class}ָ��ʹ��ValidGroup1�����У��
	//@ModelAttribute����ָ��pojo���Ե�ҳ����request�е�key
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(Model model,HttpServletRequest request,Integer id,
		@ModelAttribute("items") @Validated(value={ValidGroup1.class})	ItemsCustom itemsCustom,BindingResult bindingResult) throws Exception {

		//��ȡУ����Ϣ
		if(bindingResult.hasErrors()){
			//���������Ϣ
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			for(ObjectError objectError:allErrors){
				System.out.println(objectError.getDefaultMessage());				
			}
			//��������Ϣ����ҳ��
			model.addAttribute("allErrors",allErrors);
			
			//����ֱ��ʹ��model���ύpojo���Ե�ҳ��
			model.addAttribute("items",itemsCustom);
			
			//���������ݻ���
			//model.addAttribute("id",id);
			
			//�������µ���Ʒ�޸�ҳ��
			return "items/editItems";
		}
		
		//����service������Ʒ��Ϣ��ҳ����Ҫ����Ʒ����Ϣ�����˷���
		itemsService.UpdateItems(id, itemsCustom);
		
		//�ض�����Ʒ��ѯ�б�
		//return "redirect:queryItems.action";
		
		//ҳ��ת��
		return "forward:queryItems.action";

	}
	
	//����json��ʽ����
	@RequestMapping("/getItemsJson")
	public void getItemsJson(HttpServletResponse response) throws Exception {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charse=utf-8");
		response.getWriter().write("{name:zhangsan}");

	}
	
	
	/** 
	* @Title: deleteItems 
	* @Description: ����ɾ����Ʒ��Ϣ
	* @param @param items_id
	* @param @return
	* @param @throws Exception    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	*/
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id)throws Exception{
		
		return "success";		
	}
	
	
	/** 
	* @Title: editItemsQuery 
	* @Description: �����޸���Ʒҳ�棬����Ʒ��Ϣ��ѯ��������ҳ���п��Ա༭��Ʒ��Ϣ
	* @param @param request
	* @param @param itemsQueryVo
	* @param @return
	* @param @throws Exception    �趨�ļ� 
	* @return ModelAndView    �������� 
	* @throws 
	*/
	@RequestMapping("/editItemsQuery")
	public ModelAndView editItemsQuery(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception {

		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

		// ����ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// �൱��request��setAttribut,��jspҳ����ͨ��itemsListȡ����
		modelAndView.addObject("itemsList", itemsList);
		// ָ����ͼ	
		modelAndView.setViewName("items/editItemsQuery");

		return modelAndView;
	}
	
	
	//�����޸���Ʒ�ύ
	//ͨ��ItemsQueryVo���������ύ����Ʒ��Ϣ������Ʒ��Ϣ�洢��itemsQueryVo�е�itemsList������
	@RequestMapping("/editItemsAllSubmit")
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception{
		
		return "success";		
	}

}
