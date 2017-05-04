package com.elink.hospitalhealthnurse.modules.sys.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.elink.hospitalhealthnurse.common.config.Global;
import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.modules.sys.entity.Area;
import com.elink.hospitalhealthnurse.modules.sys.entity.Office;
import com.elink.hospitalhealthnurse.modules.sys.service.AreaService;
import com.elink.hospitalhealthnurse.modules.sys.service.OfficeService;
import com.elink.hospitalhealthnurse.modules.sys.vo.AreaVO;
import com.elink.hospitalhealthnurse.modules.sys.vo.OfficeVO;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 机构医院管理Controller
 * @author 颜福艳
 * @version 2016-10-09
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/office")
public class OfficeController extends BaseController {

	@Autowired
	private OfficeService officeService;
	@Autowired
	private AreaService areaService;
	
	@ModelAttribute
	public Office get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return officeService.get(id);
		}else{
			return new Office();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(Office office, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<OfficeVO> page = officeService.find(new Page<OfficeVO>(request, response), office); 
        model.addAttribute("page", page);
		return "modules/" + "sys/officeList";
	}

	@RequestMapping(value = "form")
	public String form(Office office, Model model) {
		model.addAttribute("office", office);
		List<Area> provinceList = areaService.findJgAll();
		model.addAttribute("provinceList", provinceList);
		if(office != null && StringUtils.isNotEmpty(office.getProvince())){
			List<AreaVO> cityList = areaService.findListByParentId(office.getProvince());
			model.addAttribute("cityList", cityList);
		}
		if(office != null && StringUtils.isNotEmpty(office.getCity())){
			List<AreaVO> areaList = areaService.findListByParentId(office.getCity());
			model.addAttribute("areaList", areaList);
		}
		return "modules/" + "sys/officeForm";
	}

	@RequestMapping(value = "save")
	public String save(Office office, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, office)){
			return form(office, model);
		}
		officeService.save(office);
		addMessage(redirectAttributes, "保存医院管理成功");
		return "redirect:"+Global.getAdminPath()+"/sys/office/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		officeService.delete(id);
		addMessage(redirectAttributes, "删除医院管理成功");
		return "redirect:"+Global.getAdminPath()+"/sys/office/?repage";
	}
	
	@RequiresUser
	@ResponseBody
	@RequestMapping("treeData")
	public List<Map<String, Object>> treeData(HttpServletResponse response) {
		response.setContentType("application/json; charset=UTF-8");
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<Office> list = officeService.findAll();
		for (int i=0; i<list.size(); i++){
			Office e = list.get(i);
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("name", e.getName());
				mapList.add(map);
		}
		return mapList;
	}

}
