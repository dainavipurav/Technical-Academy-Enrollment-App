package com.learning.springboot.technicalacademyenrollmentapp.clients;

import com.learning.springboot.technicalacademyenrollmentapp.dto.email.EmailRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.success.SuccessResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class EmailServiceClient {

    private final RestClient restClient;

    @Value("${services.email.base-url}")
    private String emailServiceUrl;


    public void sendEnrollmentEmail(EmailRequestDto request){
        SuccessResponseDto successResponseDto = restClient.post()
                .uri(URI.create(emailServiceUrl))
                .body(request)
                .retrieve()
                .body(SuccessResponseDto.class);

        System.out.println("Success : " + successResponseDto.toString());
    }


}
