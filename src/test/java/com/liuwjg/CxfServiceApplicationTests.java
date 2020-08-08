package com.liuwjg;

import com.liuwjg.webservice.IHelloService;
import com.liuwjg.webservice.impl.User;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CxfServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test1() {
        String url = "http://localhost:8080/services/hello?wsdl";
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setAddress(url);
        jaxWsProxyFactoryBean.setUsername("");
        jaxWsProxyFactoryBean.setServiceClass(IHelloService.class);
        IHelloService helloService = (IHelloService) jaxWsProxyFactoryBean.create();
        String result = helloService.hello("12131");
        System.out.println(result);
    }

    @Test
    void test2() {
        String url = "http://localhost:8080/services/hello?wsdl";
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(url);
        Object[] objects;
        try {
            objects = client.invoke("hello", "12321");
            System.out.println(objects[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void test3() {
        String url = "http://localhost:8080/services/hello?wsdl";
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(url);
        Object[] objects;

        User user = new User(1, "liuwjg", "liuwjg@fotile.com");
        try {
            objects = client.invoke("getUser", user);
            User user1 = (User)(objects[0]);
            System.out.println(user1.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
