package com.jx.agile.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import java.util.List;
import java.util.Map;

public class JacksonUtil {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(JacksonUtil.class);

    private static ObjectMapper mapper;

    static {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        mapper = builder.createXmlMapper(false)
                .build();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }


    public static String beanToJson(Object data) {
        try {
            if(null == data){
                return null;
            }
            String result = mapper.writeValueAsString(data);
            return result;
        } catch (JsonProcessingException e) {
           log.error("jackson beanToJson exception :{}",e.getMessage());
        }
        return null;
    }

    public static <T> T jsonToBean(String jsonData, Class<T> beanType) {
        try {
            if(StringUtils.isBlank(jsonData)){
                return null;
            }
            T result = mapper.readValue(jsonData, beanType);
            return result;
        } catch (Exception e) {
            log.error("jackson jsonToBean exception :{}",e.getMessage());
        }

        return null;
    }

    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, beanType);

        try {
            if(StringUtils.isBlank(jsonData)){
                return null;
            }
            List<T> resultList = mapper.readValue(jsonData, javaType);
            return resultList;
        } catch (Exception e) {
            log.error("jackson jsonToList exception :{}",e.getMessage());
        }

        return null;
    }

    public static <K, V> Map<K, V> jsonToMap(String jsonData, Class<K> keyType, Class<V> valueType) {
        JavaType javaType = mapper.getTypeFactory().constructMapType(Map.class, keyType, valueType);

        try {
            if(StringUtils.isBlank(jsonData)){
                return null;
            }
            Map<K, V> resultMap = mapper.readValue(jsonData, javaType);
            return resultMap;
        } catch (Exception e) {
            log.error("jackson jsonToMap exception :{}",e.getMessage());
        }

        return null;
    }

}
