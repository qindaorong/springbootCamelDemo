package com.qindaorong.springboot.config;

import javax.xml.ws.Endpoint;

import com.qindaorong.springboot.webservice.CamelCXFServiceInter;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther: qindaorong
 * @Date: 2018/6/28 11:34
 * @Description:
 */
@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;

    @Autowired
    CamelCXFServiceInter camelCXFServiceInter;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, camelCXFServiceInter);
        endpoint.publish("/CamelCXFService/queryService");
        return endpoint;
    }

}
