
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.qindaorong.springboot.webservice;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.5
 * 2018-06-26T17:47:01.454+08:00
 * Generated source version: 3.2.5
 *
 */

@WebService(
                      serviceName = "CamelCXFServiceImplService",
                      targetNamespace = "http://server.cxf.camel.com/",
                      endpointInterface = "com.qindaorong.springboot.webservice.CamelCXFServiceInter")
@Component
public class CamelCXFServiceImplPortImpl implements CamelCXFServiceInter {

    private static final Logger LOG = Logger.getLogger(CamelCXFServiceImplPortImpl.class.getName());

    /* (non-Javadoc)
     * @see com.camel.cxf.server.CamelCXFServiceInter#queryInfomation(java.lang.String arg0)*
     */
    @Override
    public String queryInfomation(String arg0) {
        LOG.info("Executing operation queryInfomation");
        //System.out.println(arg0);
        return arg0;

    }

    /* (non-Javadoc)
     * @see com.camel.cxf.server.CamelCXFServiceInter#sayHello(java.lang.String arg0)*
     */
    @Override
    public String sayHello(String arg0) {
        LOG.info("Executing operation sayHello");
        //System.out.println(arg0);
        return "hello";
    }

}
