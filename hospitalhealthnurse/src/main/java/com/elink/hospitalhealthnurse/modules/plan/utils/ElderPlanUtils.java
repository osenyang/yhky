package com.elink.hospitalhealthnurse.modules.plan.utils;

import java.util.Date;

import com.elink.hospitalhealthnurse.common.utils.Consts;
import com.elink.hospitalhealthnurse.common.utils.DateUtils;

/***
 * 
 * @author elink
 *
 */
public class ElderPlanUtils {
	/***
	 * 根据参数获取过去的日期
	 * @param statType (1:最近一周，2:最近一月，3:最近一季, 4: 最近一年,4:自定义)
	 * @return
	 */
	public static String getPastDate(String statType){
		String pastDate = "";
		if(Consts.STATE_TYPE_WEEK.equals(statType)){						
			pastDate = DateUtils.formatDate(DateUtils.addDays(new Date(), -7));				
		}else if(Consts.STATE_TYPE_MONTH.equals(statType)){				
			pastDate = DateUtils.formatDate(DateUtils.addMonths(new Date(),-1));
		}else if(Consts.STATE_TYPE_SEASON.equals(statType)){					
			pastDate = DateUtils.formatDate(DateUtils.addMonths(new Date(),-3));	
		}else if(Consts.STATE_TYPE_YEAR.equals(statType)){					
			pastDate = DateUtils.formatDate(DateUtils.addYears(new Date(),-1));	
		}else {
			pastDate = DateUtils.formatDate(DateUtils.addDays(new Date(), -7));		
		}
		return pastDate;
	}
}
