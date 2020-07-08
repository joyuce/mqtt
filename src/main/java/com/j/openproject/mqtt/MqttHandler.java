package com.j.openproject.mqtt;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Joyuce
 * @Type MqttHandler
 * @Desc
 * @date 2020年03月13日
 * @Version V1.0
 */
@Slf4j
public class MqttHandler implements MessageHandler {
    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        Object payLoad = message.getPayload();
        byte[] data = (byte[]) payLoad;
        String payload = new String(data);
        String topic = message.getHeaders().get("mqtt_receivedTopic").toString();
        // 根据topic分别进行消息处理。
        if (topic.equals("topic1")) {
            System.out.println("topic1: 处理消息 " + payload);
        } else if (topic.equals("topic2")) {
            System.out.println("topic2: 处理消息 " + payload);
        } else {
            System.out.println(topic + ": 丢弃消息 " + payload);
        }
    }
}
