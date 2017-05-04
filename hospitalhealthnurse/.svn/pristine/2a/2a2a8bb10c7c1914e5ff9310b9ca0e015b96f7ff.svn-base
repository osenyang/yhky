package com.elink.hospitalhealthnurse.modules.sys.interceptor;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.elink.hospitalhealthnurse.common.mapper.JsonMapper;
import com.elink.hospitalhealthnurse.common.vo.ReturnCodeSimple;
import com.elink.hospitalhealthnurse.modules.sys.service.SystemService;
import com.google.common.collect.Maps;

/***
 * 客户端接口拦截器
 * @author elink
 *
 */
public class WsInterceptor implements HandlerInterceptor {
	
	 private static final String[] IGNORE_URI = 
	 {
		 "/ws/dict/", 
		 "/ws/area/",		 
		 "/ws/user/",
		 "/ws/tvWallPlan/"
	 };
	
	@Autowired
	private SystemService systemService;
	 
	private String mappingURL;//利用正则映射到需要拦截的路径    
    public void setMappingURL(String mappingURL) {    
       this.mappingURL = mappingURL;    
    }   
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		  
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {	
		HttpSession session = request.getSession();
		String url=request.getRequestURL().toString();  
//		if(url.indexOf(mappingURL) != -1){				
//			for (String s : IGNORE_URI) {
//	            if (url.indexOf(s) != -1) {
//	            	return true;
//	            }
//	        }
//			String tokenId = request.getParameter("tokenId");
//			if(session.getAttribute(tokenId) != null){
//				return true;
//			}else{
//				if(this.systemService.isExistsToken(tokenId)){
//				    response.setCharacterEncoding("UTF-8");  
//				    response.setContentType("text/html;charset=UTF-8");  
//					PrintWriter out = response.getWriter();  
//					ReturnCodeSimple returnCodeErr = new ReturnCodeSimple();
//					Map<String, Object> headErr = Maps.newHashMap();
//					headErr.put("ret", 1);
//					headErr.put("msg", "授权令牌验证没有通过，请确认是否发送授权令牌！");				
//					returnCodeErr.setHead(headErr);			
//					String json = JsonMapper.getInstance().toJsonWs(returnCodeErr);
//					out.print(json);  
//		            out.close();  
//		            return false; 
//				} else{
//					session.setAttribute(tokenId,tokenId);
//					return true;
//				}
//			}           
//        }
		return true;
	}

}
