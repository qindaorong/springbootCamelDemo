package com.qindaorong.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.qindaorong.springboot.enums.RouteGroupEnum;
import com.qindaorong.springboot.enums.RouteTopicEnum;
import com.zhengtoon.framework.camel.CamelRouterService;
import com.zhengtoon.framework.camel.dto.HttpRequestParaDTO;
import com.zhengtoon.framework.camel.dto.MessageDTO;
import com.zhengtoon.framework.camel.dto.WebserviceRequestParaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: qindaorong
 * @Date: 2018/6/25 15:04
 * @Description:
 */
@RestController
public class TestController {

    @Autowired
    CamelRouterService camelRouterService;


    @RequestMapping(value = { "/hello" }, method = RequestMethod.POST)
    public String hello(@RequestParam(name = "name")String name ,@RequestParam(name = "age")String age ){
        Map<String,String> map = new HashMap<String, String>(2);
        map.put("name",name);
        map.put("age",age);
        return JSONObject.toJSONString(map);
    }

    @RequestMapping(value = { "/add" }, method = RequestMethod.GET)
    public String add(){
        Map<String,String> paraMap = new HashMap<String, String>(2);
        paraMap.put("name","qindaorong");
        paraMap.put("age","31");

        HttpRequestParaDTO httpDto = new HttpRequestParaDTO();
        httpDto.setParaMap(paraMap);
        httpDto.setRouteTopic(RouteTopicEnum.BEI_JING.getTopic());
        httpDto.setRouteGroup(RouteGroupEnum.USER.getGroup());

        MessageDTO messageDTO = camelRouterService.sendHttpRequest(httpDto);
        return JSONObject.toJSONString(messageDTO);
    }

    @RequestMapping(value = { "/testcxf" }, method = RequestMethod.GET)
    public MessageDTO testcxf(){
        Map<String,String> paraMap = new HashMap<String, String>(1);
        paraMap.put("name","leo");

        WebserviceRequestParaDTO webserviceRequestParaDTO = new WebserviceRequestParaDTO();
        webserviceRequestParaDTO.setParaMap(paraMap);
        webserviceRequestParaDTO.setRouteTopic(RouteTopicEnum.BEI_JING.getTopic());
        webserviceRequestParaDTO.setRouteGroup(RouteGroupEnum.HOUSEFOUND.getGroup());

        MessageDTO messageDTO=camelRouterService.sendWebserviceRequest(webserviceRequestParaDTO);
        return messageDTO;
    }
}
