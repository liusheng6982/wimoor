package com.wimoor.erp.inventory.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wimoor.common.mvc.FileUpload;
import com.wimoor.erp.inventory.mapper.InWarehouseFormEntryMapper;
import com.wimoor.erp.inventory.pojo.entity.InWarehouseFormEntry;
import com.wimoor.erp.inventory.service.IInWarehouseFormEntryService;
import lombok.RequiredArgsConstructor;
@Service("inWarehouseFormEntryService")
@RequiredArgsConstructor
public class InWarehouseFormEntryServiceImpl extends ServiceImpl<InWarehouseFormEntryMapper,InWarehouseFormEntry> implements IInWarehouseFormEntryService {
	 final FileUpload fileUpload;  

	public List<Map<String, Object>> selectByFormid(String formid) {
		return this.baseMapper.selectByFormid(formid);
	}
	
	public List<Map<String, Object>> findFormDetailByFormid(String formid) {
		List<Map<String, Object>> list = this.baseMapper.findFormDetailByFormid(formid);
		if(list.size()>0) {
			for(int i=0;i<list.size();i++) {
				 String image=null; 
				Map<String, Object> map = list.get(i);
				if(map.get("image")!=null)image=map.get("image").toString();
				if(map.get("image")!=null)list.get(i).put("image",fileUpload.getPictureImage(image));
				else list.get(i).put("image","images/systempicture/noimage40.png");
			}
		}
		return list;
	}

	public void deleteByFormid(String formid) {
		this.baseMapper.deleteByFormid(formid);
		
	}
 
}
