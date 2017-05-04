package com.elink.hospitalhealthnurse.modules.plan.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.druid.sql.visitor.functions.If;
import com.elink.hospitalhealthnurse.common.config.Global;
import com.elink.hospitalhealthnurse.common.mapper.JsonMapper;
import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.utils.CookieUtils;
import com.elink.hospitalhealthnurse.common.utils.DateUtils;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.common.utils.excel.ExportExcel;
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.modules.plan.entity.ServiceUserRoster;
import com.elink.hospitalhealthnurse.modules.plan.service.ServiceUserRosterService;
import com.elink.hospitalhealthnurse.modules.plan.utils.SerialNumberGenUtils;
import com.elink.hospitalhealthnurse.modules.plan.vo.ElderPlanVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.ServiceUserRosterVO;
import com.elink.hospitalhealthnurse.modules.plan.vo.TodayTaskVO;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.Department;
import com.elink.hospitalhealthnurse.modules.serviceorg.entity.ServiceUser;
import com.elink.hospitalhealthnurse.modules.serviceorg.service.DepartmentService;
import com.elink.hospitalhealthnurse.modules.serviceorg.service.ServiceUserService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 服务人员排班Controller
 * @author 王宴萍
 * @version 2016-10-11
 */
@Controller
@RequestMapping(value = "${adminPath}/plan/serviceUserRoster")
public class ServiceUserRosterController extends BaseController {

	@Autowired
	private ServiceUserRosterService serviceUserRosterService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private ServiceUserService serviceUserService;
	
	@ModelAttribute
	public ServiceUserRoster get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return serviceUserRosterService.get(id);
		}else{
			return new ServiceUserRoster();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(ServiceUserRosterVO serviceUserRosterVO,HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ServiceUserRosterVO> page = serviceUserRosterService.find(new Page<ServiceUserRosterVO>(request, response),serviceUserRosterVO); 
		if(page!=null&&page.getList()!=null&&page.getList().size()>0){
			int sameSerialNumberCount=1;
			int sameOfficeCount=1;
			String preSerivalNumberId="";
			String preOfficeId="";
			for(int i=page.getList().size()-1;i>=0;i--){
				ServiceUserRosterVO vo=page.getList().get(i);
				if(vo.getOfficeId().equals(preOfficeId)){//
					if(vo.getSerialNumber().equals(preSerivalNumberId)){
						sameSerialNumberCount++;
						page.getList().get(i+1).setSerialNumberRowspan(0);
					}else{
						sameSerialNumberCount=1;
						preSerivalNumberId=vo.getSerialNumber();
					}
					sameOfficeCount++;
					page.getList().get(i+1).setOfficeRowspan(0);
				}else{
					sameSerialNumberCount=1;
					preSerivalNumberId=vo.getSerialNumber();
					sameOfficeCount=1;
					preOfficeId=vo.getOfficeId();
				}
				page.getList().get(i).setSerialNumberRowspan(sameSerialNumberCount);//设置科室相同的行数
				page.getList().get(i).setOfficeRowspan(sameOfficeCount);//设置机构相同的行数
			}
		}
		model.addAttribute("page", page);
		return "modules/" + "plan/serviceUserRosterList";
	}
	/***
	 * 查询当日任务
	 * @param todayTaskVO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "todayTask")
	public String todayTask(TodayTaskVO todayTaskVO,HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TodayTaskVO> page = serviceUserRosterService.findTodayTask(new Page<TodayTaskVO>(request, response),todayTaskVO); 
		if(page!=null&&page.getList()!=null&&page.getList().size()>0){
			int sameDepartmentCount=1;
			int sameOfficeCount=1;
			String preDepartmentId="";
			String preOfficeId="";
			for(int i=page.getList().size()-1;i>=0;i--){
				TodayTaskVO vo=page.getList().get(i);
				
				if(vo.getOfficeId().equals(preOfficeId)){//
					if(vo.getDepartmentId().equals(preDepartmentId)){
						sameDepartmentCount++;
						page.getList().get(i+1).setDepartmentRowspan(0);
					}else{
						sameDepartmentCount=1;
						preDepartmentId=vo.getDepartmentId();
					}
					sameOfficeCount++;
					page.getList().get(i+1).setOfficeRowspan(0);
				}else{
					sameDepartmentCount=1;
					preDepartmentId=vo.getDepartmentId();
					sameOfficeCount=1;
					preOfficeId=vo.getOfficeId();
				}
				page.getList().get(i).setDepartmentRowspan(sameDepartmentCount);//设置科室相同的行数
				page.getList().get(i).setOfficeRowspan(sameOfficeCount);//设置机构相同的行数
			}
		}
		model.addAttribute("page", page);
		return "modules/" + "plan/todayTaskList";
	}
	
	/***
	 * 查询当日任务详情
	 * @param todayTaskVO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "todayTaskInfo")
	public String todayTaskInfo(TodayTaskVO todayTaskVO,HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TodayTaskVO> page = serviceUserRosterService.findTodayTask(new Page<TodayTaskVO>(request, response),todayTaskVO); 
		model.addAttribute("departmentId", todayTaskVO.getDepartmentId());
		model.addAttribute("page", page);
		return "modules/" + "plan/todayTaskInfo";
	}
	@RequestMapping(value = "form")
	public String form(ServiceUserRosterVO serviceUserRosterVO,Model model) {
		if(StringUtils.isNotBlank(serviceUserRosterVO.getId())){
			serviceUserRosterVO=serviceUserRosterService.getVO(serviceUserRosterVO.getId());
			model.addAttribute("serviceUserRosterVO", serviceUserRosterVO);
			model.addAttribute("beginDateStr", DateUtils.formatDateTime(serviceUserRosterVO.getBeginDate()));
		}
		if(StringUtils.isNotBlank(serviceUserRosterVO.getSerialNumber())){
			List<ServiceUserRosterVO> serviceUserRosterVOs=serviceUserRosterService.findBySerialNumber(serviceUserRosterVO.getSerialNumber());
			model.addAttribute("serviceUserRosterVOs", serviceUserRosterVOs);
		}
		return "modules/" + "plan/serviceUserRosterForm";
	}

	@RequestMapping(value = "save")
	public String save(ServiceUserRosterVO serviceUserRosterVO, Model model, RedirectAttributes redirectAttributes,HttpServletRequest request, HttpServletResponse response) {
		if (!beanValidator(model, serviceUserRosterVO)){
			return form(serviceUserRosterVO, model);
		}
		String serviceUserIdStr=request.getParameter("serviceUserIds");
		String selectedDateStr=request.getParameter("selectedDates");
		String[] serviceUserIds=serviceUserIdStr.split(",");
		String[] selectedDates=selectedDateStr.split(",");
//		String date=request.getParameter("beginDate");
		String beginTime=request.getParameter("beginTime");
		String endTime=request.getParameter("endTime");
		String serialNumber=SerialNumberGenUtils.genSerialNumber();
//		String[] dates=request.getParameterValues("dates");
		boolean havaConflict=false;
		StringBuilder sBuilder=new StringBuilder();
		List<ServiceUserRoster> serviceUserRosters=new ArrayList<ServiceUserRoster>();
		for(String serviceUserId:serviceUserIds){
			if(StringUtils.isNotBlank(serviceUserId)){
				for(String date:selectedDates){
					if(StringUtils.isNotBlank(date)){//存在并大于当前日期
						Date rosterDate=DateUtils.getDateTimeByString(date+" 00:00:00");
						if(DateUtils.compareCurrDate(rosterDate)){
							Date beginDate=DateUtils.getDateTimeByString(date+" "+beginTime+":00");
							Date endDate=DateUtils.getDateTimeByString(date+" "+endTime+":00");
							serviceUserRosterVO.setBeginDate(beginDate);
							serviceUserRosterVO.setEndDate(endDate);
							boolean isHaveRoster=serviceUserRosterService.isHaveRoster(serviceUserId,serviceUserRosterVO.getSerialNumber(), beginDate, endDate);
							ServiceUserRoster serviceUserRoster=new ServiceUserRoster();
							serviceUserRoster.setSerialNumber(serialNumber);
							serviceUserRoster.setServiceUserId(serviceUserId);
							serviceUserRoster.setBeginDate(beginDate);
							serviceUserRoster.setEndDate(endDate);
							serviceUserRosters.add(serviceUserRoster);
							if(isHaveRoster){
								sBuilder.append("<br/>").append("排班日期"+date+"有服务人员排班冲突。");
								havaConflict=true;
							}
						}
					}
				}
			}
		}
		if(!havaConflict){//没有排班有时间冲突
			for(ServiceUserRoster serviceUserRoster:serviceUserRosters){
				serviceUserRosterService.save(serviceUserRoster);
			}
			if(StringUtils.isNotBlank(serviceUserRosterVO.getSerialNumber())){
				serviceUserRosterService.delBySerialNumberAfterToday(serviceUserRosterVO.getSerialNumber());
			}
			addMessage(redirectAttributes,"保存成功");
			return "redirect:"+Global.getAdminPath()+"/plan/serviceUserRoster/?repage";
		}else {
			model.addAttribute("beginDateStr", DateUtils.formatDateTime(serviceUserRosterVO.getBeginDate()));
			model.addAttribute("serviceUserRosterVO", serviceUserRosterVO);
			model.addAttribute("serviceUserRosterVOs", serviceUserRosters);
			model.addAttribute("message", "保存出错:"+sBuilder.toString());
			return "modules/" + "plan/serviceUserRosterForm";
//			return "redirect:"+Global.getAdminPath()+"/plan/serviceUserRoster/form/?repage";
		}
	}
	
	@RequestMapping(value = "delete")
	public String delete(String id, RedirectAttributes redirectAttributes) {
		serviceUserRosterService.delete(id);
		addMessage(redirectAttributes, "删除成功");
		return "redirect:"+Global.getAdminPath()+"/plan/serviceUserRoster/?repage";
	}
	@RequestMapping(value = "deleteBySerialNb")
	public String deleteBySerialNb(String serialNumber, RedirectAttributes redirectAttributes) {
		serviceUserRosterService.delBySerialNumber(serialNumber);
		addMessage(redirectAttributes, "删除成功");
		return "redirect:"+Global.getAdminPath()+"/plan/serviceUserRoster/?repage";
	}
	/**
	 * 服务人员Tree结构信息
	 * @param response
	 * @return
	 * @throws Exception
	 * @author 王宴萍 2016-10-12
	 */
	@RequestMapping(value = "serviceUserTreeData")
	@ResponseBody
	public List<Map<String, Object>> serviceUserTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("application/json; charset=UTF-8");
		String departmentId = request.getParameter("departmentId");
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<ServiceUser> serviceUsers = serviceUserService.findByDepartment(departmentId);
		Department department=departmentService.get(departmentId);
		Map<String, Object> p = Maps.newHashMap();
		p.put("id", department.getId());
		p.put("pId", "0");
		p.put("name", department.getName());
		p.put("nocheck", "true");
		p.put("isParent", true);
		p.put("open", true);
		
		mapList.add(p);
		for (int t = 0; t < serviceUsers.size(); t++) {
			ServiceUser su = serviceUsers.get(t);
			Map<String, Object> a = Maps.newHashMap();
			a.put("id", su.getId());
			a.put("pId", su.getDepartmentId());
			a.put("name", su.getName());
			a.put("nocheck", "false");
			a.put("isParent", false);
			a.put("open", true);
			mapList.add(a);
		}
		return mapList;
	}
	/**
	 * 排班人员Tree结构信息
	 * @param response
	 * @return
	 * @throws Exception
	 * @author 王宴萍 2016-10-12
	 */
	@RequestMapping(value = "rosterUserTreeData")
	@ResponseBody
	public List<Map<String, Object>> rosterUserTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("application/json; charset=UTF-8");
		String serialNumber = request.getParameter("serialNumber");
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<ServiceUserRosterVO> serviceUserRosterVOs=serviceUserRosterService.findBySerialNumber(serialNumber);
		List<String> departmentIds=new ArrayList<String>();
		List<String> userIds=new ArrayList<String>();
		for (int t = 0; t < serviceUserRosterVOs.size(); t++) {
			ServiceUserRosterVO su = serviceUserRosterVOs.get(t);
			if(!departmentIds.contains(su.getDepartmentId())){
				departmentIds.add(su.getDepartmentId());
				Map<String, Object> p = Maps.newHashMap();
				p.put("id", su.getDepartmentId());
				p.put("pId", "0");
				p.put("name", su.getDepartmentName());
				p.put("nocheck", "true");
				p.put("isParent", true);
				p.put("open", true);
				mapList.add(p);
			}
			if(!userIds.contains(su.getServiceUserId())){
				userIds.add(su.getServiceUserId());
				Map<String, Object> a = Maps.newHashMap();
				a.put("id", su.getServiceUserId());
				a.put("pId", su.getDepartmentId());
				a.put("name", su.getServiceUserName());
				a.put("nocheck", "false");
				a.put("isParent", false);
				a.put("open", true);
				mapList.add(a);
			}
		}
		return mapList;
	}
	/**
	 * 获取排班日常集合数据(返回JSON格式)
	 */
	@ResponseBody
	@RequestMapping(value = "listJson")
	public List<Map<String, Object>> listJson(ServiceUserRosterVO serviceUserRosterVO, HttpServletResponse response){
		response.setContentType("application/json; charset=UTF-8");
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<ServiceUserRosterVO> list = serviceUserRosterService.findRosterDate(serviceUserRosterVO);
		for (ServiceUserRosterVO roster : list) {
			Map<String, Object> map = Maps.newHashMap();
			map.put("beginDate", DateUtils.formatDateTime(roster.getBeginDate()).split(" ")[0]);
			map.put("endDate", DateUtils.formatDateTime(roster.getEndDate()).split(" ")[0]);
			map.put("title", "上班");
			mapList.add(map);
		}
		return mapList;
	}
	
	/**
	 * 服务人员排班界面
	 */
	@RequestMapping(value = "rosterForm")
	public String rosterForm(ServiceUserRoster serviceUserRoster,Model model,HttpServletRequest request, HttpServletResponse response) {
		serviceUserRoster=serviceUserRosterService.get(serviceUserRoster.getId());
//		String serialNumber=serviceUserRoster.getSerialNumber();
//		String beginDateStr=request.getParameter("beginDateStr");
		if(serviceUserRoster!=null){
			model.addAttribute("serialNumber", serviceUserRoster.getSerialNumber());
			model.addAttribute("beginDateStr",  DateUtils.formatDateTime(serviceUserRoster.getBeginDate()).split(" ")[0]);
		}
		return "modules/" + "plan/rosterFullCalendar";
	}
	@RequestMapping(value = "planStatChart")
	public String planStatChart(ElderPlanVO elderPlanVO, HttpServletRequest request, HttpServletResponse response, Model model) {
//        List<About> list = aboutService.find(about); 
        model.addAttribute("elderPlanVO", elderPlanVO);
		return "modules/" + "plan/planStatChart";
	}
	
	/****
	 * 获取计划统计数据
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getPlanStatTrend")
	@ResponseBody
	public String  getPlanStatTrend(HttpServletRequest request,HttpServletResponse response) {
		String departmentId = request.getParameter("departmentId");
		String statType = request.getParameter("statType");		

		if(StringUtils.isNotBlank(statType)){
			CookieUtils.setCookie(response, "statType", statType);
		}else{
			statType = CookieUtils.getCookie(request, "statType");
		}		
		Map<String,Object[]>  returnCode = serviceUserRosterService.getPlanStatValue(departmentId,statType);
		return JsonMapper.getInstance().toJsonWs(returnCode);				
	}	
	/**
	 * 排班导出
	 * @author yfy
	 */
	@RequestMapping(value = "exportExcel", method=RequestMethod.POST)
    public String exportExcel(ServiceUserRosterVO serviceUserRosterVO,HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			Page<ServiceUserRosterVO> pageM=new Page<ServiceUserRosterVO>(request, response);
			pageM.setPageSize(200);
			pageM.setPageNo(0);
			String serialNumber=serviceUserRosterVO.getSerialNumber();
			serviceUserRosterVO.setSerialNumber(request.getParameter("exeSerialNumber"));
			Page<ServiceUserRosterVO> page = serviceUserRosterService.find(pageM,serviceUserRosterVO); 
			serviceUserRosterVO.setSerialNumber(serialNumber);
			if(page!=null&&page.getList()!=null&&page.getList().size()>0){
				int sameSerialNumberCount=1;
				int sameOfficeCount=1;
				String preSerivalNumberId="";
				String preOfficeId="";
				for(int i=page.getList().size()-1;i>=0;i--){
					ServiceUserRosterVO vo=page.getList().get(i);
					if(vo.getOfficeId().equals(preOfficeId)){//
						if(vo.getSerialNumber().equals(preSerivalNumberId)){
							sameSerialNumberCount++;
							page.getList().get(i+1).setSerialNumberRowspan(0);
						}else{
							sameSerialNumberCount=1;
							preSerivalNumberId=vo.getSerialNumber();
						}
						sameOfficeCount++;
						page.getList().get(i+1).setOfficeRowspan(0);
					}else{
						sameSerialNumberCount=1;
						preSerivalNumberId=vo.getSerialNumber();
						sameOfficeCount=1;
						preOfficeId=vo.getOfficeId();
					}
					page.getList().get(i).setSerialNumberRowspan(sameSerialNumberCount);//设置科室相同的行数
					page.getList().get(i).setOfficeRowspan(sameOfficeCount);//设置机构相同的行数
				}
			}
			StringBuilder sbBuilder=new StringBuilder();
			if(StringUtils.isNotBlank(serviceUserRosterVO.getServiceUserName())){
				sbBuilder.append(serviceUserRosterVO.getServiceUserName()+"-");
			}
			if(StringUtils.isNotBlank(serviceUserRosterVO.getDepartmentName())){
				sbBuilder.append(serviceUserRosterVO.getDepartmentName()+"-");
			}
			if(StringUtils.isNotBlank(serviceUserRosterVO.getSerialNumber())){
				sbBuilder.append(serviceUserRosterVO.getSerialNumber()+"-");
			}
			if(serviceUserRosterVO.getBeginDate()!=null){
				sbBuilder.append(DateUtils.formatDateTime(serviceUserRosterVO.getBeginDate())+"-");
			}
			if(serviceUserRosterVO.getEndDate()!=null){
				sbBuilder.append(DateUtils.formatDateTime(serviceUserRosterVO.getEndDate())+"-");
			}
			sbBuilder.append(DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx");
			String fileName = "排班数据-"+sbBuilder.toString(); 
			String title ="服务人员排班数据";
			new ExportExcel().getServiceUserRosterExcel(page.getList(), title).write(response, fileName).dispose();
			return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出数据失败！失败信息："+e.getMessage());
		}
		return "redirect:"+Global.getAdminPath()+"/plan/serviceUserRoster?repage";
    }
}
