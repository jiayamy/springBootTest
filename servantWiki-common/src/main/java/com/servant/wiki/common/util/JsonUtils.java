/**
 * ClassName: JsonUtils
 * CopyRight: TalkWeb
 * Date: 12-11-27
 * Version: 1.0
 */
package com.servant.wiki.common.util;


import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import net.sf.json.util.PropertyFilter;

import java.util.*;

/**
 * Description :
 * User : zhanglingzhi
 */
public class JsonUtils {

    public static final String TIME_STAMP_FORMAT_Y_M_D_H_M_S  = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_STAMP_FORMAT_Y_M_D  = "yyyy-MM-dd";
    public static final String TIME_STAMP_FORMAT_H_M_S  = "HH:mm:ss";

    static JsonConfig jsonConfig;

    static {
        String[] formats = new String[]{TIME_STAMP_FORMAT_Y_M_D_H_M_S, TIME_STAMP_FORMAT_Y_M_D, TIME_STAMP_FORMAT_H_M_S};
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(formats));
        jsonConfig = JsonConfigFactory.buildJsonConfig(TIME_STAMP_FORMAT_Y_M_D_H_M_S);
//        jsonConfig.setExcludes(new String[]{"userPassword"});
//        jsonConfig = JsonConfigFactory.registerDefaultProcessor();
        jsonConfig = JsonConfigFactory.setFilter(new NullAvoidFilter());
    }

    public static String toJson(Object o) {
//        JsonConfig jsonConfig = JsonConfigFactory.buildJsonConfig(Constants.TIME_STAMP_FORMAT_Y_M_D_H_M_S);
        if (o instanceof Collection) {
            return JSONArray.fromObject(o, jsonConfig).toString();
        }
        return JSONObject.fromObject(o, jsonConfig).toString();
    }

    public static String toJson(Object o, JsonConfig jsonConfig) {
        //        JsonConfig jsonConfig = JsonConfigFactory.buildJsonConfig(Constants.TIME_STAMP_FORMAT_Y_M_D_H_M_S);
        if (o instanceof Collection) {
            return JSONArray.fromObject(o, jsonConfig).toString();
        }
        return JSONObject.fromObject(o, jsonConfig).toString();
    }

    public static String toJson(Object o, PropertyFilter... propertyFilters) {
        JsonConfig jsonConfig1 = new JsonConfig();
        jsonConfig1.registerJsonValueProcessor(Date.class, new DateProcessor(TIME_STAMP_FORMAT_Y_M_D_H_M_S));
        jsonConfig1.registerJsonValueProcessor(java.sql.Date.class, new DateProcessor(TIME_STAMP_FORMAT_Y_M_D_H_M_S));
        for (PropertyFilter propertyFilter : propertyFilters) {
            jsonConfig1.setJsonPropertyFilter(propertyFilter);
        }

        return toJson(o, jsonConfig1);
    }

    public static String toJson(Object o, String[] excludes, PropertyFilter... propertyFilters) {
        JsonConfig jsonConfig1 = new JsonConfig();
        jsonConfig1.setExcludes(excludes);
        jsonConfig1.registerJsonValueProcessor(Date.class, new DateProcessor(TIME_STAMP_FORMAT_Y_M_D_H_M_S));
        jsonConfig1.registerJsonValueProcessor(java.sql.Date.class, new DateProcessor(TIME_STAMP_FORMAT_Y_M_D_H_M_S));
        for (PropertyFilter propertyFilter : propertyFilters) {
            jsonConfig1.setJsonPropertyFilter(propertyFilter);
        }

        return toJson(o, jsonConfig1);
    }

    public static <T> List<T> toBeans(List<Map<String, Object>> items, Class clazz) {
        List<T> resultList = new ArrayList<T>();
        for (Map<String, Object> item : items) {
            resultList.add((T) JsonUtils.toBean(item, clazz));
        }
        return resultList;
    }

    public static <T> List<T> toBeans(List<Map<String, Object>> items, Class clazz, Map<String, Class> classMap) {
        List<T> resultList = new ArrayList<T>();
        for (Map<String, Object> item : items) {
            resultList.add((T) JsonUtils.toBean(item, clazz, classMap));
        }
        return resultList;
    }
    public static void main(String[] agrs) {        /*String json = "[{\"parentNick\":null,\"parentMobile\":\"15399892899\",\"fatherName\":null,\"motherName\":null,\"schoolId\":null,\"classId\":\"1018001001342399\",\"parentId\":\"21018001001468568\",\"joinTime\":null,\"parentAccount\":\"15399892899\",\"studentId\":null,\"studentNo\":null,\"lodgingStatus\":null,\"nativePlace\":null,\"familyPhone\":null,\"familyAdd\":null,\"status\":9,\"userId\":\"31018001001903345\",\"userAccount\":\"s15399892899\",\"userMobile\":\"\",\"userNick\":\"伍帝州\",\"userIcon\":\"\",\"birthday\":\"2012-12-01 00:00:00\",\"userType\":3,\"userPassword\":\"e10adc3949ba59abbe56e057f20f883e\",\"lastUpdateTime\":null,\"nation\":\"1\",\"sex\":1,\"email\":\"\",\"firstIndex\":\"W\",\"regTime\":\"2012-12-07 10:35:22\"},{\"parentNick\":null,\"parentMobile\":\"13574832764\",\"fatherName\":null,\"motherName\":null,\"schoolId\":null,\"classId\":\"1018001001342399\",\"parentId\":\"21018001001107135\",\"joinTime\":null,\"parentAccount\":\"13574832764\",\"studentId\":null,\"studentNo\":null,\"lodgingStatus\":null,\"nativePlace\":null,\"familyPhone\":null,\"familyAdd\":null,\"status\":0,\"userId\":\"31018001001190597\",\"userAccount\":\"s13574832764\",\"userMobile\":\"\",\"userNick\":\"刘灿\",\"userIcon\":\"\",\"birthday\":\"2012-12-01 00:00:00\",\"userType\":3,\"userPassword\":\"e10adc3949ba59abbe56e057f20f883e\",\"lastUpdateTime\":null,\"nation\":\"1\",\"sex\":1,\"email\":\"\",\"firstIndex\":\"L\",\"regTime\":\"2012-12-07 10:38:33\"},{\"parentNick\":null,\"parentMobile\":\"15111182045\",\"fatherName\":null,\"motherName\":null,\"schoolId\":null,\"classId\":\"1018001001342399\",\"parentId\":\"21018001001012442\",\"joinTime\":null,\"parentAccount\":\"15111182045\",\"studentId\":null,\"studentNo\":null,\"lodgingStatus\":null,\"nativePlace\":null,\"familyPhone\":null,\"familyAdd\":null,\"status\":0,\"userId\":\"31018001001513413\",\"userAccount\":\"s15111182045\",\"userMobile\":\"\",\"userNick\":\"刘依\",\"userIcon\":\"http://192.168.141.248/weixiao/msg_photo/210180010010124421320620907.png\",\"birthday\":\"2012-12-01 00:00:00\",\"userType\":3,\"userPassword\":\"e10adc3949ba59abbe56e057f20f883e\",\"lastUpdateTime\":\"2012-12-11 08:39:36\",\"nation\":\"1\",\"sex\":2,\"email\":\"\",\"firstIndex\":\"L\",\"regTime\":\"2012-12-07 10:39:37\"},{\"parentNick\":null,\"parentMobile\":\"13467560536\",\"fatherName\":null,\"motherName\":null,\"schoolId\":null,\"classId\":\"1018001001342399\",\"parentId\":\"21018001001601123\",\"joinTime\":null,\"parentAccount\":\"13467560536\",\"studentId\":null,\"studentNo\":null,\"lodgingStatus\":null,\"nativePlace\":null,\"familyPhone\":null,\"familyAdd\":null,\"status\":0,\"userId\":\"31018001001539762\",\"userAccount\":\"s13467560536\",\"userMobile\":\"\",\"userNick\":\"康维\",\"userIcon\":\"\",\"birthday\":\"2012-12-06 00:00:00\",\"userType\":3,\"userPassword\":\"e10adc3949ba59abbe56e057f20f883e\",\"lastUpdateTime\":null,\"nation\":\"1\",\"sex\":1,\"email\":\"\",\"firstIndex\":\"K\",\"regTime\":\"2012-12-07 10:40:26\"},{\"parentNick\":null,\"parentMobile\":\"15874209913\",\"fatherName\":null,\"motherName\":null,\"schoolId\":null,\"classId\":\"1018001001342399\",\"parentId\":\"21018001001024551\",\"joinTime\":null,\"parentAccount\":\"15874209913\",\"studentId\":null,\"studentNo\":null,\"lodgingStatus\":null,\"nativePlace\":null,\"familyPhone\":null,\"familyAdd\":null,\"status\":0,\"userId\":\"31018001001148854\",\"userAccount\":\"s15874209913\",\"userMobile\":\"\",\"userNick\":\"孔思耘\",\"userIcon\":\"\",\"birthday\":\"2012-12-06 00:00:00\",\"userType\":3,\"userPassword\":\"e10adc3949ba59abbe56e057f20f883e\",\"lastUpdateTime\":null,\"nation\":\"1\",\"sex\":2,\"email\":\"\",\"firstIndex\":\"K\",\"regTime\":\"2012-12-07 10:42:09\"}]";
        List<StudentDetail> students = toBeans(json,StudentDetail.class);
    	for(StudentDetail student : students){
    		System.out.println(student.getUserNick());
    	}*/
    	

    	
    
    	
//        Map<String, Object> map = new HashMap<String, Object>();
//        Map<String, Object> outMap = new HashMap<String, Object>();
//        Set<String> set = new HashSet<String>();
//        set.add("a");
//        map.put("a", "a");
//        map.put("b", null);
//        map.put("c", "c");
//        outMap.put("out", map);
//        JsonConfig jsonConfig1 = JsonConfigFactory.buildJsonConfig(Constants.TIME_STAMP_FORMAT_Y_M_D_H_M_S);
//        jsonConfig1.setExcludes(new String[]{"c"});
//
//        System.out.println(toJson(outMap, jsonConfig1));
//        System.out.println(toJson(outMap, new NullAvoidFilter(),
//                new PasswordShieldFilter(), new FieldPickFilter(set)));
    }


    public static <T> List<T> toBeans(String json, Class clazz) {
        JSONArray array = JSONArray.fromObject(json);
        List<Map<String, Object>> items = JSONArray.fromObject(array);
        return toBeans(items, clazz);
    }

    public static <T> T toBean(String json, Class clazz) {
        return (T) JSONObject.toBean(JSONObject.fromObject(json), clazz);
    }

    public static <T> T toBean(Map<String, Object> map, Class clazz) {
        return (T) JSONObject.toBean(JSONObject.fromObject(map), clazz);
    }

    public static <T> T toBean(String json, Class clazz, Map<String, Class> classMap) {
        return (T) JSONObject.toBean(JSONObject.fromObject(json), clazz, classMap);
    }

    public static <T> T toBean(Map<String, Object> map, Class clazz, Map<String, Class> classMap) {
        return (T) JSONObject.toBean(JSONObject.fromObject(map), clazz, classMap);
    }

    public static Map<String, Object> fromJson(String json) {
        Map<String, Object> parameters = new HashMap<String, Object>();
//        JsonConfig jsonConfig = JsonConfigFactory.buildJsonConfig(Constants.TIME_STAMP_FORMAT_Y_M_D_H_M_S);
        try {
            Map<String, Object> map = JSONObject.fromObject(json, jsonConfig);
            for (String key : map.keySet()) {
                if (map.get(key) instanceof JSONObject) {  //对象类型处理
                    JSONObject jsonObject = (JSONObject) map.get(key);
                    Map<String, Object> obj = JSONObject.fromObject(jsonObject, jsonConfig);
                    parameters.put(key, obj);
                } else if (map.get(key) instanceof JSONArray) { //数组类型处理
                    JSONArray jsonArray = (JSONArray) map.get(key);
                    //构建一个list对象，保存数组
                    List<Object> innerList = new ArrayList<Object>();
                    for (Object aJsonArray : jsonArray) {
                        if (aJsonArray instanceof JSONObject) {
                            Map<String, Object> innerMap = (Map<String, Object>) aJsonArray;
                            innerList.add(innerMap);
                        } else if (aJsonArray instanceof String) {
                            innerList.add(aJsonArray);
                        } else if (aJsonArray instanceof Integer) {
                            innerList.add(aJsonArray);
                        }
                    }
                    parameters.put(key, innerList);

                } else if (map.get(key) instanceof JSONNull) {
                    parameters.put(key, null);
                } else {    //其他类型
                    parameters.put(key, map.get(key));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("解析请求中的json串失败", e);
        }

        return parameters;
    }
}
