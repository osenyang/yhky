/**
 * Copyright (c) 2005-2012 springside.org.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
/**
 * Copyright (c) 2005-2012 springside.org.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.elink.hospitalhealthnurse.common.mapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.elink.hospitalhealthnurse.common.utils.StringUtils;
import com.elink.hospitalhealthnurse.common.vo.ReturnCode;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 简单封装Jackson，实现JSON String<->Java Object的Mapper.
 * 
 * 封装不同的输出风格, 使用不同的builder函数创建实例.
 * 
 * @author calvin
 * @version 2013-01-15
 */
public class JsonMapper extends ObjectMapper {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(JsonMapper.class);

	private static JsonMapper mapper;

	public JsonMapper() {
		this(Include.NON_EMPTY);
	}

	public JsonMapper(Include include) {
		// 设置输出时包含属性的风格
		if (include != null) {
			this.setSerializationInclusion(include);
		}
		// 允许单引号、允许不带引号的字段名称
		this.enableSimple();
		// 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		this.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 空值处理为空串
		this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>(){
			@Override
			public void serialize(Object value, JsonGenerator jgen,
					SerializerProvider provider) throws IOException,
					JsonProcessingException {
				jgen.writeString("");
			}
        });
	}

	/**
	 * 创建只输出非Null且非Empty(如List.isEmpty)的属性到Json字符串的Mapper,建议在外部接口中使用.
	 */
	public static JsonMapper getInstance() {
		if (mapper == null){
			mapper = new JsonMapper().enableSimple();
		}
		return mapper;
	}

	/**
	 * 创建只输出初始值被改变的属性到Json字符串的Mapper, 最节约的存储方式，建议在内部接口中使用。
	 */
	public static JsonMapper nonDefaultMapper() {
		if (mapper == null){
			mapper = new JsonMapper(Include.NON_DEFAULT);
		}
		return mapper;
	}
	
	/**
	 * Object可以是POJO，也可以是Collection或数组。
	 * 如果对象为Null, 返回"null".
	 * 如果集合为空集合, 返回"[]".
	 */
	public String toJson(Object object) {
		try {
			return this.writeValueAsString(object);
		} catch (IOException e) {
			logger.warn("write to json string error:" + object, e);
			return null;
		}
	}
	
	/**
	 * 将object转换为JSON字符串,并格式化HTML字符，将转义符转为HTML字符
	 * @param object
	 * Object可以是POJO，也可以是Collection或数组。
	 * 如果对象为Null, 返回"null".
	 * 如果集合为空集合, 返回"[]".
	 */
	public String toJsonWs(Object object){
		try {
			String result = writeValueAsString(object);
			return StringUtils.formatHtml(result);						
		} catch (IOException e) {
			logger.warn("write to json string error:" + object, e);
			return null;
		}	
	}

	/**
	 * 反序列化POJO或简单Collection如List<String>.
	 * 
	 * 如果JSON字符串为Null或"null"字符串, 返回Null.
	 * 如果JSON字符串为"[]", 返回空集合.
	 * 
	 * 如需反序列化复杂Collection如List<MyBean>, 请使用fromJson(String,JavaType)
	 * @see #fromJson(String, JavaType)
	 */
	public <T> T fromJson(String jsonString, Class<T> clazz) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}
		try {
			return this.readValue(jsonString, clazz);
		} catch (IOException e) {
			logger.warn("parse json string error:" + jsonString, e);
			return null;
		}
	}

	/**
	 * 反序列化复杂Collection如List<Bean>, 先使用函數createCollectionType构造类型,然后调用本函数.
	 * @see #createCollectionType(Class, Class...)
	 */
	@SuppressWarnings("unchecked")
	public <T> T fromJson(String jsonString, JavaType javaType) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}
		try {
			return (T) this.readValue(jsonString, javaType);
		} catch (IOException e) {
			logger.warn("parse json string error:" + jsonString, e);
			return null;
		}
	}

	/**
	 * 構造泛型的Collection Type如:
	 * ArrayList<MyBean>, 则调用constructCollectionType(ArrayList.class,MyBean.class)
	 * HashMap<String,MyBean>, 则调用(HashMap.class,String.class, MyBean.class)
	 */
	public JavaType createCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return this.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

	/**
	 * 當JSON裡只含有Bean的部分屬性時，更新一個已存在Bean，只覆蓋該部分的屬性.
	 */
	@SuppressWarnings("unchecked")
	public <T> T update(String jsonString, T object) {
		try {
			return (T) this.readerForUpdating(object).readValue(jsonString);
		} catch (JsonProcessingException e) {
			logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
		} catch (IOException e) {
			logger.warn("update json string:" + jsonString + " to object:" + object + " error.", e);
		}
		return null;
	}

	/**
	 * 輸出JSONP格式數據.
	 */
	public String toJsonP(String functionName, Object object) {
		return toJson(new JSONPObject(functionName, object));
	}

	/**
	 * 設定是否使用Enum的toString函數來讀寫Enum,
	 * 為False時時使用Enum的name()函數來讀寫Enum, 默認為False.
	 * 注意本函數一定要在Mapper創建後, 所有的讀寫動作之前調用.
	 */
	public JsonMapper enableEnumUseToString() {
		this.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
		this.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
		return this;
	}

	/**
	 * 支持使用Jaxb的Annotation，使得POJO上的annotation不用与Jackson耦合。
	 * 默认会先查找jaxb的annotation，如果找不到再找jackson的。
	 */
	public JsonMapper enableJaxbAnnotation() {
		JaxbAnnotationModule module = new JaxbAnnotationModule();
		this.registerModule(module);
		return this;
	}

	/**
	 * 允许单引号
	 * 允许不带引号的字段名称
	 */
	public JsonMapper enableSimple() {
		this.configure(Feature.ALLOW_SINGLE_QUOTES, true);
		this.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		return this;
	}
	
	/**
	 * 取出Mapper做进一步的设置或使用其他序列化API.
	 */
	public ObjectMapper getMapper() {
		return this;
	}
	
	/**
	 * 转换为JSON字符串
	 * @param object
	 * @return
	 */
	public static String toJsonString(Object object){
		return JsonMapper.getInstance().toJson(object);
	}
	
	/**
	 * 测试
	 */
	public static void main(String[] args) {
		List<Map<String, Object>> list = Lists.newArrayList();
		Map<String, Object> map = Maps.newHashMap();
		map.put("id", 1);
		map.put("pId", -1);
		map.put("name", "根节点");
		list.add(map);
		map = Maps.newHashMap();
		map.put("id", 2);
		map.put("pId", 1);
		map.put("name", "你好");
		map.put("open", true);
		list.add(map);
		String json = JsonMapper.getInstance().toJson(list);
		
		ReturnCode returnCode = new ReturnCode();
		Map<String, Object> head = Maps.newHashMap();
		head.put("ret", 1003);
		head.put("msg", "登录失败，帐号密码错");
//		
//
//		
//		List<Object> result = new ArrayList<Object>();
//		Food food = new Food();
//		food.setId("1");
//		food.setFoodNm("蒜容肉丝");
//		food.setIngredients("食材");
//		
//		
//		result.add(food);
//		result.add(food);
//		
//		returnCode.setHead(head);
//		returnCode.setData(result);
//		String jsonString = "{\"head\":{\"ret\":0,\"msg\":\"成功\"},\"data\":[{\"breakfast\":[{\"classId\":\"d3d5bc84f91d41cab8a6c6c3c13a7c27\",\"classNm\":\"素菜\",\"foodClassData\":[{\"id\":\"66093263ec1a4a29835d21dd717cbd83\",\"foodNm\":\"蛋炒饭\",\"unit\":\"元\",\"price\":10.0,\"foodImg\":\"|/elink/userfiles/2/images/course/food/2015/01/%E8%87%AA%E5%8A%A9%E7%BB%88%E7%AB%AF_2.jpg\",\"ingredients\":\"姜\",\"remarks\":\"姜\"},{\"id\":\"6fc188e8dbb54ba2963aa024ba8bfec4\",\"foodNm\":\"木耳肉片\",\"unit\":\"元\",\"price\":16.0,\"foodImg\":\"|/elink/userfiles/2/images/course/food/2015/01/call.jpg\",\"ingredients\":\"木耳,肉片\",\"suitableContent\":\"糖尿病\",\"avoidContent\":\"心脏病\",\"remarks\":\"木耳,肉片\"}]},{\"classId\":\"dcaf0701519b4a45a15c68505d8430bf\",\"classNm\":\"肉类\",\"foodClassData\":[{\"id\":\"6fc188e8dbb54ba2963aa024ba8bfec4\",\"foodNm\":\"木耳肉片\",\"unit\":\"元\",\"price\":16.0,\"foodImg\":\"|/elink/userfiles/2/images/course/food/2015/01/call.jpg\",\"ingredients\":\"木耳,肉片\",\"suitableContent\":\"糖尿病\",\"avoidContent\":\"心脏病\",\"remarks\":\"木耳,肉片\"}]}],\"lunch\":[{\"classId\":\"d3d5bc84f91d41cab8a6c6c3c13a7c27\",\"classNm\":\"素菜\",\"foodClassData\":[{\"id\":\"66093263ec1a4a29835d21dd717cbd83\",\"foodNm\":\"蛋炒饭\",\"unit\":\"元\",\"price\":10.0,\"foodImg\":\"|/elink/userfiles/2/images/course/food/2015/01/%E8%87%AA%E5%8A%A9%E7%BB%88%E7%AB%AF_2.jpg\",\"ingredients\":\"姜\",\"remarks\":\"姜\"},{\"id\":\"6fc188e8dbb54ba2963aa024ba8bfec4\",\"foodNm\":\"木耳肉片\",\"unit\":\"元\",\"price\":16.0,\"foodImg\":\"|/elink/userfiles/2/images/course/food/2015/01/call.jpg\",\"ingredients\":\"木耳,肉片\",\"suitableContent\":\"糖尿病\",\"avoidContent\":\"心脏病\",\"remarks\":\"木耳,肉片\"}]},{\"classId\":\"dcaf0701519b4a45a15c68505d8430bf\",\"classNm\":\"肉类\",\"foodClassData\":[{\"id\":\"6fc188e8dbb54ba2963aa024ba8bfec4\",\"foodNm\":\"木耳肉片\",\"unit\":\"元\",\"price\":16.0,\"foodImg\":\"|/elink/userfiles/2/images/course/food/2015/01/call.jpg\",\"ingredients\":\"木耳,肉片\",\"suitableContent\":\"糖尿病\",\"avoidContent\":\"心脏病\",\"remarks\":\"木耳,肉片\"}]}]}]}";
//		
//		ReturnCode code = JsonMapper.getInstance().fromJson(jsonString, ReturnCode.class) ;
//		System.out.println();

	}
	
}
