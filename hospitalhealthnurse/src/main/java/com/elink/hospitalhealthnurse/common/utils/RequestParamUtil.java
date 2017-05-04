package com.elink.hospitalhealthnurse.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 查询条件参数处理工具类,用于查询列表分页时，修改，删除时返回到当前页面
 * @author 刘灵星 
 * @param 
 */
public class RequestParamUtil {


	/***
	 * 获取原来的查询条件，用于查询列表分页时，修改，删除操作成功后返回到当前页面
	 * @param name 名称
	 * @param value 查询条件内容
	 * @param request 
	 * @param response
	 * @return
	 */
	public static String getRequestParamJosn(String name,Object value,HttpServletRequest request, HttpServletResponse response){
		if(request.getParameter("repage")!=null){
			if(CookieUtils.getCookie(request, name) != null){
				String jsonArr  = CookieUtils.getCookie(request, name);	
				return jsonArr;
			}
		}else{
			CookieUtils.setCookieObject(response, name, value);
		}
		return null;
	}
}
