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
	
	
	/** 
	* @Title: findItemsById 
	* @Description: ����id��ѯ��Ʒ��Ϣ 
	* @param @param id
	* @param @return
	* @param @throws Exception    �趨�ļ� 
	* @return ItemsCustom    �������� 
	* @throws 
	*/
	public ItemsCustom findItemsById(int id) throws Exception;
	
	
	/** 
	* @Title: UpdateItems 
	* @Description: �޸���Ʒ��Ϣ
	* @param @param id
	* @param @param itemsCustom
	* @param @throws Exception    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	public void UpdateItems(int id,ItemsCustom itemsCustom) throws Exception;
	
	
	

}
 