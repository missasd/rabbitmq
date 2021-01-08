package com.imooc;

import com.imooc.pojo.Order;
import com.imooc.producer.OrderSender;
import com.imooc.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;


@SpringBootTest
class RabbitmqApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private OrderSender orderSender;

    @Autowired
    private OrderService orderService;

    @Test
    public void testSend1() throws Exception{
        Order order = new Order();
        order.setId(2020010702);
        order.setName("测试订单2");
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
        orderSender.send(order);
    }

    @Test
    public void testCreate() throws Exception{
        Order order = new Order();
        order.setId(2018092105);
        order.setName("测试订单4");
        order.setMessageId(System.currentTimeMillis()+"$"+UUID.randomUUID().toString());
        orderService.createOrder(order);
    }
}
