package com.imooc.producer;


import com.imooc.pojo.Order;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Order order) throws Exception{
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessageId());
        /**
         *  exchange, routingKey, 消息具体内容, correlationData 消息唯一ID
         */
        rabbitTemplate.convertAndSend("order-exchange", "order.abcd", order,
                correlationData);
    }

}
