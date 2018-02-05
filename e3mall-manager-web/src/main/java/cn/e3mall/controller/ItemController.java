package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;
import cn.e3mall.utils.UIPageBean;

@RestController // 此注解即将controller交给了springMVC管理,又将返回值转换成json格式
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/{itemId}")
	public TbItem findItemById(@PathVariable Long itemId) {
		return itemService.findItemById(itemId);
	}
	
	@RequestMapping("/list")
	public UIPageBean list(@RequestParam(defaultValue="1") Integer page , @RequestParam(defaultValue="30") Integer rows){
		UIPageBean uIPageBean= itemService.findItemsByPage(page,rows);
		return uIPageBean;
		
	}

}
