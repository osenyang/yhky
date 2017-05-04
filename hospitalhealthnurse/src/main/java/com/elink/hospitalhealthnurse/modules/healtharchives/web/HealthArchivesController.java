package com.elink.hospitalhealthnurse.modules.healtharchives.web;

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
import com.elink.hospitalhealthnurse.common.mapper.JsonMapper;
import com.elink.hospitalhealthnurse.common.persistence.Page;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.common.web.BaseController;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.AssessReport;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.HealthArchives;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.HealthAssess;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.HealthInpatient;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Information;
import com.elink.hospitalhealthnurse.modules.healtharchives.entity.Intervene;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.AssessReportService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HealthArchivesService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HealthAssessService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HealthInpatientService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.InformationService;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.InterveneService;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.HealthArchivesVO;
import com.elink.hospitalhealthnurse.modules.plan.service.PlanExecuteRecordService;
import com.elink.hospitalhealthnurse.modules.serviceorg.vo.ServiceUserVO;
import com.elink.hospitalhealthnurse.modules.sys.entity.User;
import com.elink.hospitalhealthnurse.modules.sys.service.SystemService;
import com.elink.hospitalhealthnurse.modules.sys.utils.UserUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 健康档案Controller
 * @author 杜康
 * @version 2016-10-11
 */
@Controller
@RequestMapping(value = "${adminPath}/healtharchives/healthArchives")
public class HealthArchivesController extends BaseController {

	@Autowired
	private HealthArchivesService healthArchivesService;
	
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private InformationService informationService;
	
	@Autowired
	private InterveneService interveneService;
	
	@Autowired
	private HealthInpatientService healthInpatientService;
	
	@Autowired
	private HealthAssessService healthAssessService;
	
	@Autowired
	private AssessReportService assessReportService;
	
	@Autowired
	private PlanExecuteRecordService planExecuteRecordService;
	
	@ModelAttribute
	public HealthArchives get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return healthArchivesService.get(id);
		}else{
			return new HealthArchives();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(HealthArchives healthArchives, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		Page<HealthArchives> page = healthArchivesService.find(new Page<HealthArchives>(request, response), healthArchives); 
        List<HealthInpatient> list = healthInpatientService.findByOfficeId(user.getOffice().getId());
        model.addAttribute("page", page);
        model.addAttribute("list", list);
		return "modules/" + "healtharchives/healthArchivesList";
	}

	@RequestMapping(value = "form")
	public String form(HealthArchives healthArchives, Model model) {
		User user = UserUtils.getUser();
		List<HealthInpatient> list = healthInpatientService.findByOfficeId(user.getOffice().getId());
		model.addAttribute("healthArchives", healthArchives);
		model.addAttribute("list", list);
		return "modules/" + "healtharchives/healthArchivesForm";
	}
	
	@RequestMapping(value = "find")
	public String find(HealthArchives healthArchives, Model model,String startDate, String endDate) {
		User user = new User();
		if(StringUtils.isNotBlank(healthArchives.getUserId())){
			user = systemService.getUser(healthArchives.getUserId());
		}
		if(StringUtils.isNotEmpty(user.getLoginName())){
			healthArchives.setAccount(user.getLoginName());
		}
		List<HealthAssess> healthAssessList = healthAssessService.findByArchivesId(healthArchives.getId());
		List<AssessReport> assessReportList = assessReportService.findByArchivesId(healthArchives.getId());
		model.addAttribute("healthAssessList", healthAssessList);
		model.addAttribute("assessReportList", assessReportList);
		model.addAttribute("healthArchives", healthArchives);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("assessList", healthArchivesService.getAssessResultVOList(healthArchives.getIdCard(), startDate, endDate));
		return "modules/" + "healtharchives/healthArchivesDetail";
	}

	@RequestMapping(value = "save")
	public String save(HealthArchives healthArchives, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, healthArchives)){
			return form(healthArchives, model);
		}
		HealthArchives oldHealthArchives  = null;
		if(StringUtils.isNotBlank(healthArchives.getId())){
			oldHealthArchives = healthArchivesService.get(healthArchives.getId());
		}else{
			oldHealthArchives = new HealthArchives();
		}
		boolean b = true;
		if(StringUtils.isNotBlank(oldHealthArchives.getIdCard()) && healthArchives.getIdCard().equals(oldHealthArchives.getIdCard())){
			b  = false;
		}else if(!healthArchivesService.validateIdCard(healthArchives.getIdCard())){
			b = false;
		}
		if(b){
			healthArchivesService.evict(healthArchives); 
			addMessage(model, "身份证已重复!");
			return form(healthArchives, model);
		}
		b=true;
		if(!healthArchivesService.validateBedNumber(healthArchives.getBedNumber(),healthArchives.getInpatientId(),healthArchives.getId())){
			b = false;
		}
		if(b){
			healthArchivesService.evict(healthArchives); 
			addMessage(model, "当前床号已有人!");
			return form(healthArchives, model);
		}
		try {
			healthArchivesService.saveHealthArchivesByWs(healthArchives,UserUtils.getUser().getOffice().getId());
			if(interveneService.findInterveneByArchivesId(healthArchives.getId())){
				Intervene inter = new Intervene();
				inter.setArchivesId(healthArchives.getId());
				inter.setState(Intervene.INTER_STATE_NORMAL);
				interveneService.save(inter);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		addMessage(redirectAttributes, "保存健康档案成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/healthArchives/?repage";
	}
	
	/**
	 * 添加干预方案
	 * */
	@RequestMapping(value = "saveIntervene")
	public String saveIntervene(String archivesId, Model model, RedirectAttributes redirectAttributes) {
		try {
			if(interveneService.findInterveneByArchivesId(archivesId)){
				Intervene inter = new Intervene();
				inter.setArchivesId(archivesId);
				inter.setState(Intervene.INTER_STATE_NORMAL);
				interveneService.save(inter);
			}else{
				addMessage(redirectAttributes, "添加失败，已有干预方案");
				return "redirect:"+Global.getAdminPath()+"/healtharchives/healthArchives/?repage";
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		addMessage(redirectAttributes, "添加干预方案成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/intervene/?repage";
	}
	/**
	 * 判断住院号是否重复
	 * */
	@ResponseBody
	@RequestMapping("checkHospitalizationNumber")
	public String checkHospitalizationNumber(String oldHospitalizationNumber,String hospitalizationNumber) throws Exception {
		if(StringUtils.isNotBlank(hospitalizationNumber) && hospitalizationNumber.equals(oldHospitalizationNumber)) {
			return "true";
		}else {
			if (hospitalizationNumber != null) {
				if(healthArchivesService.validateHospitalizationNumber(hospitalizationNumber)){
					return "false";
				}else{
					return "true";
				}
			}
		}
		return "false";
	}
	
	/**
	 * 判断床号是否重复
	 * */
	@ResponseBody
	@RequestMapping("checkBedNumber")
	public String checkBedNumber(String oldBedNumber,String bedNumber,String inpatientId,String oldInpatientId,String id) throws Exception {
		if(StringUtils.isNotBlank(bedNumber) && bedNumber.equals(oldBedNumber) && inpatientId.equals(oldInpatientId)) {
			return "true";
		}else {
			if (bedNumber != null) {
				if(healthArchivesService.validateBedNumber(bedNumber,inpatientId,id)){
					return "false";
				}else{
					return "true";
				}
			}
		}
		return "false";
	}
	
	/**
	 * 发起综合会诊
	 * @author dk
	 * 
	 * */
	@RequestMapping(value = "diagnosis")
	public String diagnosis(HealthArchives healthArchives,Information information, Model model){
		model.addAttribute("healthArchives", healthArchives);
		model.addAttribute("information", information);
		return "modules/healtharchives/healthArchivesDiagnosis";
	}
	
	
	@RequestMapping(value = "delete")
	public String delete(HealthArchives healthArchives, RedirectAttributes redirectAttributes) {
		if(StringUtils.isNotBlank(healthArchives.getUserId())){
			User user = systemService.getUser(healthArchives.getUserId());
			systemService.deleteUser(user.getId());
		}
		healthArchivesService.delete(healthArchives.getId());
		addMessage(redirectAttributes, "删除健康档案成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/healthArchives/?repage";
	}
	/**
	 * 出院
	 * */
	@RequestMapping(value = "leave")
	public String leave(HealthArchives healthArchives, RedirectAttributes redirectAttributes){
		healthArchives.setState(HealthArchives.STATE_LEAVE_HOSPITAL);
		healthArchivesService.save(healthArchives);
		if(!interveneService.findInterveneByArchivesId(healthArchives.getId())){
			Intervene intervene = interveneService.findIntervene(healthArchives.getId());
			interveneService.updateState(intervene.getId(), Intervene.INTER_STATE_STOP);
			planExecuteRecordService.delTodayUnExePlanRecord(intervene.getId());
		}
		addMessage(redirectAttributes, "出院成功");
		return "redirect:"+Global.getAdminPath()+"/healtharchives/healthArchives/?repage";
	}
	/**
	 * 发送综合会诊消息
	 * @author dk
	 * @data 2016-10-21 
	 * */
	@RequestMapping(value = "saveInformation")
	public String saveInformation(Information infor,HttpServletRequest request){
		User user = UserUtils.getUser();
		if(StringUtils.isNotBlank(user.getJobNumber())){
			infor.setSendJobNumber(user.getJobNumber());
		}
		String jobNumbers = request.getParameter("jobNumbers");
		if(StringUtils.isNotBlank(jobNumbers)){
			String[] jobArr = jobNumbers.split(",");
			informationService.saveBean(infor, jobArr);
		}
		/*Intervene inter = new Intervene();
		inter.setArchivesId(infor.getArchivesId());
		inter.setState(Intervene.INTER_STATE_NORMAL);
		interveneService.save(inter);*/
		return "redirect:"+Global.getAdminPath()+"/healtharchives/healthArchives/?repage";
	}
	/**
	 * 构造医护人员树结构
	 * @param extId
	 * @param response
	 * @return
	 * @author dk
	 */
	@RequiresUser
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		response.setContentType("application/json; charset=UTF-8");
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<ServiceUserVO> list = healthArchivesService.findServiceUser();
		for (int i=0; i<list.size(); i++){
			ServiceUserVO e = list.get(i);
			if (extId == null || (extId!=null && !extId.equals(e.getId()))){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getJobNumber());
				map.put("pId", 0);
				map.put("name", e.getName()+" ("+e.getDepartmentNm()+")");
				mapList.add(map);
			}
		}
		return mapList;
	}
	
	/**
	 * 根据住院编号查询用户
	 * @param hospitalizationNumber
	 * @return
	 * @author yfy
	 */
	@ResponseBody
	@RequestMapping(value = "selectHealth")
	public String selectHealth(String hospitalNumber) {
		HealthArchivesVO healthArchives = healthArchivesService.getUserByHospitalNumber(hospitalNumber);
		Map<String, Object> json = Maps.newHashMap();
		json.put("healthArchives", healthArchives);
		return JsonMapper.getInstance().toJson(json);
	}
}
