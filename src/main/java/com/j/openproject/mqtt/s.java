package com.j.openproject.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Joyuce
 * @Type s
 * @Desc
 * @date 2020年03月13日
 * @Version V1.0
 */
@RestController
@RequestMapping("mqtt")
public class s {
    @Autowired
    private MqttSend mqttSend;


    @PostMapping
    public String send(String msg, String val) {
        mqttSend.sendToMqtt(msg);
        return "success";
    }
}
