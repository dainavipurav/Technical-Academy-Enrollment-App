package com.learning.springboot.technicalacademyenrollmentapp.tasks;

import com.learning.springboot.technicalacademyenrollmentapp.clients.InvoiceServiceClient;
import com.learning.springboot.technicalacademyenrollmentapp.dto.invoice.InvoiceRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.invoice.InvoiceResponseDto;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class GenerateInvoiceTask implements Runnable{

    private final InvoiceServiceClient invoiceServiceClient;

    private final InvoiceRequestDto invoiceRequestDto;

    @Override
    public void run() {
        try{
            System.out.println("Sleeping thread..." + LocalDateTime.now());
            Thread.sleep(0); //1 min delay

            InvoiceResponseDto invoiceResponseDto = invoiceServiceClient.generateInvoice(invoiceRequestDto);
        }catch (InterruptedException exception) {

            Thread.currentThread().interrupt();

            System.out.println("Invoice task was interrupted.");

        } catch (Exception exception) {

            System.err.println("Invoice generation failed: " + exception.getMessage());
            throw new RuntimeException(exception);
        }
    }
}
