package com.dem.eventprocessor;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/test")
public class TestProducer {
    private final KafkaTemplate<String,String> kafka;
    public TestProducer(KafkaTemplate<String,String> kafka){ this.kafka = kafka; }
    @PostMapping("/send/{topic}")
    public String send(@PathVariable String topic, @RequestBody String payload){
        kafka.send(topic, payload);
        return "sent";
    }
}
