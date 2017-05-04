package com.elink.hospitalhealthnurse.modules.sys.web.ws;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elink.hospitalhealthnurse.common.mapper.JsonMapper;
import com.elink.hospitalhealthnurse.common.utils.DateUtils;
import com.elink.hospitalhealthnurse.common.utils.IdGen;
import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeSimpleEx;
import com.elink.hospitalhealthnurse.modules.healtharchives.service.HealthArchivesService;
import com.elink.hospitalhealthnurse.modules.healtharchives.vo.HealthArchivesVO;
import com.elink.hospitalhealthnurse.modules.sys.entity.SysToken;
import com.elink.hospitalhealthnurse.modules.sys.service.SystemService;
import com.elink.hospitalhealthnurse.modules.sys.vo.LoginUser;
import com.google.common.collect.Maps;

/**
 * 账号管理客户端接口类，用于用户登录，忘记密码等操作
 * @author 刘灵星
 * @version 2013-5-29
 */
@Controller
@RequestMapping(value = "${adminPath}/ws/user")
@SuppressWarnings("static-access")
public class WsUserController {	
	
	public static final String VALIDATE_CODE = "validateCode";
	
	@Autowired	
	private SystemService systemService;
	@Autowired
	private HealthArchivesService healthArchivesService;
	
	/****
	 * 用户登录,用户账号进行登录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "sysLogin",method=RequestMethod.POST)
	@ResponseBody
	public String sysLogin(HttpServletRequest request,@RequestParam String loginName,@RequestParam String password,HttpServletResponse response){
		if(StringUtils.isBlank(loginName)){
			return this.systemService.getErrReturnCode("登录失败，用户名为空！");
		}
		if(StringUtils.isBlank(password)){
			return this.systemService.getErrReturnCode("登录失败，密码为空！");
		}
		LoginUser user = systemService.getUserByLoginNameWs(loginName);
		if (user != null) {
			Boolean bool = systemService.validatePassword(password,user.getPassword());
			if(bool){		
				String tokenId = IdGen.uuid();
				SysToken sysToken = new SysToken();		
				sysToken.setNewDate(new Date());
				sysToken.setTokenId(tokenId);				
				sysToken.setValidityDate(DateUtils.addDays(new Date(), 1));
				sysToken.setLoginName(user.getLoginName());
				systemService.deleteToken(user.getLoginName());
				systemService.saveSysToken(sysToken);				
				ReturnCodeSimpleEx code = new ReturnCodeSimpleEx();
				Map<String, Object> head = Maps.newHashMap();
				head.put("ret", 0);
				head.put("msg", "登录成功");	
				Map<String, Object> codedata = Maps.newHashMap();
				codedata.put("userId", user.getId());
				codedata.put("name", user.getName());
				codedata.put("tokenId", tokenId);
				HealthArchivesVO archives = healthArchivesService.getUserByUserId(user.getId());
				if(archives != null){
					codedata.put("photo", archives.getPhoto());
				}
				code.setHead(head);
				code.setData(codedata);
				return JsonMapper.getInstance().toJsonWs(code);
			}else{
				return this.systemService.getErrReturnCode("登录失败，密码错误");
			}
		}else{
			return this.systemService.getErrReturnCode("登录失败，没有该用户！");
		}
	}
	
	/****
	 * 修改密码
	 * @param request
	 * @param response
	 * @return
	 */	
	@RequestMapping(value = "updatePwd",method=RequestMethod.POST)
	@ResponseBody
	public String updatePwd(@RequestParam String loginName,@RequestParam String oldPassword,@RequestParam String newPassword,HttpServletRequest request,HttpServletResponse response){
		String tokenId = request.getParameter("tokenId");
		if(this.systemService.isExistsToken(tokenId)){
			return systemService.getTokenErr();
		}
		if(StringUtils.isBlank(loginName)){
			return this.systemService.getErrReturnCode("密码修改失败,用户名为空！");
		}
		if(StringUtils.isBlank(oldPassword)){
			return this.systemService.getErrReturnCode("密码修改失败,旧密码为空！");
		}
		if(StringUtils.isBlank(newPassword)){
			return this.systemService.getErrReturnCode("密码修改失败,新密码为空！");
		}
		LoginUser user = systemService.getUserByLoginNameWs(loginName);
		if (user != null) {
			Boolean bool = systemService.validatePassword(oldPassword,user.getPassword());
			if(bool){	
				systemService.updatePasswordById(user.getId(), user.getLoginName(), newPassword);
				ReturnCodeSimpleEx code = new ReturnCodeSimpleEx();
				Map<String, Object> head = Maps.newHashMap();
				head.put("ret", 0);
				head.put("msg", "密码修改成功！");					
				code.setHead(head);
				code.setData(null);
				return JsonMapper.getInstance().toJsonWs(code);
			}else{
				return this.systemService.getErrReturnCode("密码修改失败,旧密码不正确");
			}
		}else{
			return this.systemService.getErrReturnCode("密码修改失败,用户名不正确！");
		}
	}
	
	/****
	 * 设置新密码
	 * @param request
	 * @param response
	 * @return
	 */	
	@RequestMapping(value = "setNewPwd",method=RequestMethod.POST)
	@ResponseBody
	public String setNewPwd(@RequestParam String loginName,@RequestParam String newPassword,HttpServletRequest request, HttpServletResponse response){
		if(StringUtils.isBlank(loginName)){
			return this.systemService.getErrReturnCode("密码修改失败,用户名为空！");
		}	
		LoginUser user = systemService.getUserByLoginNameWs(loginName);
		if (user != null) {
			systemService.updatePasswordById(user.getId(), user.getLoginName(), newPassword);
			ReturnCodeSimpleEx code = new ReturnCodeSimpleEx();
			Map<String, Object> head = Maps.newHashMap();
			head.put("ret", 0);
			head.put("msg", "密码修改成功！");					
			code.setHead(head);
			code.setData(null);
			return JsonMapper.getInstance().toJsonWs(code);		
		}else{
			return this.systemService.getErrReturnCode("设置新密码失败,用户名不正确！");
		}
	}
	
}
