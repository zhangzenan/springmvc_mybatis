package cn.itcast.ssm.service; 

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

/** 
 * @ClassName: ItemsService 
 * @Description: 商品管理Service
 * @author A18ccms a18ccms_gmail_com 
 * @date 2017-7-22 下午10:38:11 
 */
public interface ItemsService {	
	
	/** 
	* @Title: findItemsList 
	* @Description: 商品查询列表
	* @param @param itemsQueryVo
	* @param @return
	* @param @throws Exception    设定文件 
	* @return List<ItemsCustom>    返回类型 
	* @throws 
	*/
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	

}
 