package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

public interface ItemsMapperCustom {
	
	
	/** 
	* @Title: findItemsList 
	* @Description: ��Ʒ��Ϣ��ѯ�б�
	* @param @param itemsQueryVo
	* @param @return
	* @param @throws Exception    �趨�ļ� 
	* @return List<ItemsCustom>    �������� 
	* @throws 
	*/
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
    
}