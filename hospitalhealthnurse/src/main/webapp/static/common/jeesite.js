/*!
 * Copyright &copy; 2012-2013 <a href="https://github.com/elink">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
function include(id,path,file){if(document.getElementById(id)==null){var files=typeof file=="string"?[file]:file;for(var i=0;i<files.length;i++){var name=files[i].replace(/^\s|\s$/g,"");var att=name.split(".");var ext=att[att.length-1].toLowerCase();var isCSS=ext=="css";var tag=isCSS?"link":"script";var attr=isCSS?" type='text/css' rel='stylesheet' ":" type='text/javascript' ";var link=(isCSS?"href":"src")+"='"+path+name+"'";document.write("<"+tag+(i==0?" id="+id:"")+attr+link+"></"+tag+">")}}}function windowOpen(url,name,width,height){var top=parseInt((window.screen.height-height)/2,10),left=parseInt((window.screen.width-width)/2,10),options="location=no,menubar=no,toolbar=no,dependent=yes,minimizable=no,modal=yes,alwaysRaised=yes,"+"resizable=yes,scrollbars=yes,"+"width="+width+",height="+height+",top="+top+",left="+left;window.open(url,name,options)}function loading(mess){top.$.jBox.tip.mess=null;top.$.jBox.tip(mess,"loading",{opacity:0})}function confirmx(mess,href){top.$.jBox.confirm(mess,"系统提示",function(v,h,f){if(v=="ok"){loading("正在提交，请稍等...");location=href}},{buttonsFocus:1});top.$(".jbox-body .jbox-icon").css("top","55px");return false}$.validator.setDefaults({submitHandler:function(form){loading("正在提交，请稍等...");form.submit()},errorPlacement:function(error,element){$("#messageBox").text("输入有误，请先更正！").removeClass("alert-success").addClass("alert-error");if(element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){error.appendTo(element.parent().parent())}else{error.insertAfter(element)}}});function tableSort(configuration){var defaults={orderBy:"#orderBy",contentTable:"#contentTable",sortClass:"sort",callBack:$.noop};var config=$.extend({},defaults,configuration);var $orderBy=$(config.orderBy),$sortCol=$(config.contentTable+" th."+config.sortClass),orderBy=$orderBy.val().split(" ");$sortCol.each(function(){if($(this).hasClass(orderBy[0])){orderBy[1]=orderBy[1]&&orderBy[1].toUpperCase()=="DESC"?"down":"up";$(this).html($(this).html()+' <i class="icon icon-arrow-'+orderBy[1]+'"></i>')}});$sortCol.click(function(){var order=$(this).attr("class").split(" "),sort=$orderBy.val().split(" ");for(var i=0;i<order.length;i++){if(order[i]==config.sortClass){order=order[i+1];break}}if(order==sort[0]){sort=(sort[1]&&sort[1].toUpperCase()=="DESC"?"ASC":"DESC");$orderBy.val(order+" DESC"!=order+" "+sort?"":order+" "+sort)}else{$orderBy.val(order+" ASC")}config.callBack()})}$(document).ready(function(){$("select").select2();$(".fancybox").fancybox()});

function trim(s) { return s.replace(/^\s+|\s+$/g, ""); };
//验证身份证号并获取出生日期
function getBirthdatByIdNo(iIdNo) {
	var tmpStr = "";
	var idDate = "";
	var tmpInt = 0;
	var strReturn = "";
	
	iIdNo = trim(iIdNo);
	
	if ((iIdNo.length != 15) && (iIdNo.length != 18)) {
		//strReturn = "输入的身份证号位数错误";		
		return strReturn;
	}
	
	if (iIdNo.length == 15) {
		tmpStr = iIdNo.substring(6, 12);
		tmpStr = "19" + tmpStr;
		tmpStr = tmpStr.substring(0, 4) + "-" + tmpStr.substring(4, 6) + "-" + tmpStr.substring(6);
		
		return tmpStr;
	}
	else {
		tmpStr = iIdNo.substring(6, 14);
		tmpStr = tmpStr.substring(0, 4) + "-" + tmpStr.substring(4, 6) + "-" + tmpStr.substring(6);	
		return tmpStr;
	}
}
//是否删除空格
function Trim(str,is_global){ 
	var result; 
	result = str.replace(/(^\s+)|(\s+$)/g,""); 
	if(is_global.toLowerCase()=="g"){ 
		result = result.replace(/\s/g,""); 
	} 
	return result; 
} 
//空格输入去除
function inputSapceTrim(e,this_temp){
	this_temp.value = Trim(this_temp.value,"g");
	var keynum;
	if(window.event){ // IE
		keynum = e.keyCode
	}else if(e.which){ // Netscape/Firefox/Opera
		keynum = e.which
	}
	if(keynum == 32){
		return false;
	}
	return true;
}
//禁止输入空格
function banInputSapce(e){ 
	var keynum; 
	if(window.event){ // IE 
		keynum = e.keyCode 
	}else if(e.which){ // Netscape/Firefox/Opera 
		keynum = e.which 
	} 
	if(keynum == 32){ 
		return false; 
	} 
	return true; 
} 