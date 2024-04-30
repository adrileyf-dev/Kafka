package dev.com.kafkadev.resouces;

import dev.com.kafkadev.config.services.StringProduceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/produce")
@Log4j2
public class StringProduceResource {
    private  final StringProduceService service;
    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message){
       service.sendMessagem(message);
       log.info(message);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
