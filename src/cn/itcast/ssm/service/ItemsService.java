package cn.itcast.ssm.service; 

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

/** 
 * @ClassName: ItemsService 
 * @Description: ��Ʒ����Service
 * @author A18ccms a18ccms_gmail_com 
 * @date 2017-7-22 ����10:38:11 
 */
public interface ItemsService {	
	
	/** 
	* @Title: findItemsList 
	* @Description: ��Ʒ��ѯ�б�
	* @param @param itemsQueryVo
	* @param @return
	* @param @throws Exception    �趨�ļ� 
	* @return List<ItemsCustom>    �������� 
	* @throws 
	*/
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	

}
 