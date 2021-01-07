package com.imooc.cosumer;

import com.imooc.pojo.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrderReceiver {

    // 配置监听的哪一个队列，同时在没有queue和exchange的情况下会去创建并建立绑定关系
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "order-queue", durable = "true"),
            exchange = @Exchange(name = "order-exchange", durable = "true", type = "topic"),
            key = "order.#"
    ))


    @RabbitHandler // 如果有消息过来，在消费的时候调用这个方法
    public void onOrderMessage(@Payload Order order, @Headers Map<String, Object> headers,  Channel channel) throws Exception{
        //消费者操作
        System.out.println("---------收到消息，开始消费---------");
        System.out.println("订单ID："+order.getId());

        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        boolean multiple = false;
        channel.basicAck(deliveryTag, multiple);
    }
}
