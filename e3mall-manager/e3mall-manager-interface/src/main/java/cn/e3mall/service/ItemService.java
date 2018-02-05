package cn.e3mall.service;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.utils.UIPageBean;

public interface ItemService {

	// 根据id查询商品信息
	public TbItem findItemById(Long id);

	// 分页查询商品信息
	public UIPageBean findItemsByPage(Integer page, Integer rows);

}
