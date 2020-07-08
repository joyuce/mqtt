package com.j.openproject.mqtt;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.j.openproject.mqtt.config.MqttConfig;

/**
 * @author Joyuce
 * @Type MqttSend
 * @Desc
 * @date 2020年03月13日
 * @Version V1.0
 */
@Component
@MessagingGateway(defaultRequestChannel = MqttConfig.CHANNEL_NAME_OUT)
public interface MqttSend {

    // 定义重载方法，用于消息发送
    void sendToMqtt(String payload);

    // 指定topic进行消息发送
    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, String payload);

    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, String payload);
}
