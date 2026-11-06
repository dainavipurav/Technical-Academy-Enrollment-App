package com.learning.springboot.technicalacademyenrollmentapp.clients;

import com.learning.springboot.technicalacademyenrollmentapp.dto.invoice.InvoiceRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.invoice.InvoiceResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.net.URI;

@Component
@RequiredArgsConstructor

public class InvoiceServiceClient {

    private final RestClient restClient;

    @Value("${services.invoice.base-url}")
    private String invoiceBaseUrl;

    public InvoiceResponseDto generateInvoice(InvoiceRequestDto request){
        try {
            return restClient.post().uri(URI.create(invoiceBaseUrl))
                    .body(request)
                    .retrieve()
                    .body(InvoiceResponseDto.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
