package com.learning.springboot.technicalacademyenrollmentapp.tasks;

import com.learning.springboot.technicalacademyenrollmentapp.clients.EmailServiceClient;
import com.learning.springboot.technicalacademyenrollmentapp.clients.InvoiceServiceClient;
import com.learning.springboot.technicalacademyenrollmentapp.dto.email.EmailRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.invoice.InvoiceRequestDto;
import com.learning.springboot.technicalacademyenrollmentapp.dto.invoice.InvoiceResponseDto;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class GenerateInvoiceAndSendEmailTask implements Runnable{

    private final EmailServiceClient emailServiceClient;
    private final InvoiceServiceClient invoiceServiceClient;

    private final EmailRequestDto emailRequestDto;
    private final InvoiceRequestDto invoiceRequestDto;

    @Override
    public void run() {
        try{
            System.out.println("Sleeping thread..." + LocalDateTime.now());
            Thread.sleep(60000); //1 min delay

            System.out.println("Sending email now..." + LocalDateTime.now());
            InvoiceResponseDto invoiceResponseDto = invoiceServiceClient.generateInvoice(invoiceRequestDto);
            emailRequestDto.setInvoiceDownloadPath(invoiceResponseDto.getDownloadPath());
            emailServiceClient.sendEnrollmentEmail(emailRequestDto);
            System.out.println("Email sent successfully!" + LocalDateTime.now());
        }catch (InterruptedException exception) {

            Thread.currentThread().interrupt();

            System.out.println("Email task was interrupted.");

        } catch (Exception exception) {

            System.err.println("Email sending failed: " + exception.getMessage());
            throw new RuntimeException(exception);
        }
    }
}
