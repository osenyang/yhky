<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div class="control-group">		
	<label class="control-label" for="photo">头像：</label>
	<label id="photo" ><c:if test="${healthArchives.photo != null && healthArchives.photo != ''}"><img src='${healthArchives.photo}' style='width:35px;height:35;'></img></c:if></label>
</div>
<div class="control-group">
	<div class="from-info">	
		<label class="control-label" for="fullNm">姓名：</label>${healthArchives.fullNm}
	</div>
	
	<div class="from-info">		
		<label class="control-label" for="calf">小腿围/CM：</label>${healthArchives.calf}	
		
	</div>
</div>
<div class="control-group">
	<div class="from-info">	
		<label class="control-label" for="hospitalizationNumber">住院号：</label>${healthArchives.hospitalizationNumber}	
	</div>
	<div class="from-info">	
		<label class="control-label" for="bedNumber">床号：</label>${healthArchives.bedNumber}	
	</div>
</div>
<div class="control-group">
	<div class="from-info">		
		<label class="control-label" for="sex">性别：</label>	${healthArchives.sex}	
	</div>
	
	<div class="from-info">
		<label class="control-label" for="height">身高/CM：</label>${healthArchives.height}	
	</div>
</div>
<div class="control-group">
	<div class="from-info">			
		<label class="control-label" >身份证号：</label>${healthArchives.idCard}	
	</div>
	<div class="from-info">			
		<label class="control-label">出生日期：</label><fmt:formatDate value="${healthArchives.birthDate}" pattern="yyyy-MM-dd"/>
	</div>
</div>

<div class="control-group">
	<div class="from-info">		
		<label class="control-label" for="occupation">职业：</label>	${healthArchives.occupation}	
	</div>
	
	<div class="from-info">
		<label class="control-label" for="weight">体重/KG：</label>${healthArchives.weight}	
	</div>
</div>
<div class="control-group">
	<div class="from-info">	
		<label class="control-label" for="medicalType">医保类型：</label>	${fns:getDictLabel(healthArchives.medicalType, 'medical_type', '无')}		
	</div>
	
	<div class="from-info">
		<label class="control-label" for="degree">文化程度：</label>${fns:getDictLabel(healthArchives.degree, 'hn_culture', '无')}	
	</div>
</div>

<div class="control-group">
	<div class="from-info">
		<label class="control-label" for="state">状态：</label>${fns:getDictLabel(healthArchives.state, 'archive_state', '无')}
	</div>

	<div class="from-info">		
		<label class="control-label" for="contact">家属联系方式：</label>${healthArchives.contact}		
	</div>
</div>

<div class="control-group">
	<div class="from-info">		
		<label class="control-label" for="healthRisk">风险：</label>${healthArchives.healthRisk}	
	</div>
</div>
<div class="control-group">
	<div class="from-info">		
		<label class="control-label">快速访问：</label>
		<input type="button" class="btn" value="健康记录" onclick="jumpUrl('${ctx}/healtharchives/healthRecord/')">	
		<input type="button" class="btn" value="干预方案" onclick="jumpUrl('${ctx}/healtharchives/intervene/')">	
	</div>
</div>