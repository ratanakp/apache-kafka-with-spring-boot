package com.example.kafkaproducersconsumers.controllers;


import com.example.kafkaproducersconsumers.models.Model;
import com.example.kafkaproducersconsumers.models.SimpleModel;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping(value = "/api/kafka")
public class KafkaController {

    private KafkaTemplate<String, String > kafkaTemplate;
    private Gson jsonConverter;

    public KafkaController(KafkaTemplate<String, String> kafkaTemplate, Gson jsonConverter) {
        this.kafkaTemplate = kafkaTemplate;
        this.jsonConverter = jsonConverter;
    }

    @PostMapping(value = "")
    public ResponseEntity<String> post(@RequestBody Model model) {

        this.kafkaTemplate.send("myTopic", jsonConverter.toJson(model));

//        return new ResponseEntity<>("Looking Good!!!", HttpStatus.OK);
        return ResponseEntity.ok("Looking Good!!!");
    }


    @PostMapping("/v2")
    public ResponseEntity<Map<String, Object>> post(@RequestBody SimpleModel simpleModel) {
        this.kafkaTemplate.send("myTopic2", jsonConverter.toJson(simpleModel));
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "Looking Good!!!");
        return ResponseEntity.ok(response);
    }


    @KafkaListener(topics = "myTopic")
    public void get(String model) {

        System.out.println(model);

        Model model1 = (Model) jsonConverter.fromJson(model, Model.class);

        System.out.println(model1.toString());
    }


    @KafkaListener(topics = "myTopic2")
    public void getTopic2(String model) {
        System.out.println(model);

        SimpleModel model1 = jsonConverter.fromJson(model, SimpleModel.class);

        System.out.println(model1.toString());
    }

}
