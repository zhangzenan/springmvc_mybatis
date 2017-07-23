package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

public interface ItemsMapperCustom {
	
	
	/** 
	* @Title: findItemsList 
	* @Description: 商品信息查询列表
	* @param @param itemsQueryVo
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<ItemsCustom>    返回类型 
	* @throws 
	*/
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
    
}