package api;

import com.consumer.MQconsumer.service.RepublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmqpApi {

    @Autowired
    private RepublishService republishService;


    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/repost")
    public void sendToQueue(){
        republishService.repost();
    }
}
