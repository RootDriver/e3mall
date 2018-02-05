package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;
import cn.e3mall.utils.UIPageBean;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public TbItem findItemById(Long id) {
		TbItem tbItem = itemMapper.selectByPrimaryKey(id);
		return tbItem;
	}

	@Override
	public UIPageBean findItemsByPage(Integer page, Integer rows) {
		TbItemExample tbItemExample = new TbItemExample();
		//设置分页信息 
		PageHelper.startPage(page, rows);
		
		List<TbItem> list = itemMapper.selectByExample(tbItemExample);
		
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		UIPageBean uiPageBean = new UIPageBean();
		
		uiPageBean.setTotal(pageInfo.getTotal());
		uiPageBean.setRows(pageInfo.getList());
		
		return uiPageBean;
	}

	
}
