package com.animal.java.service;

import com.animal.java.exception.ApplicationException;
import com.animal.java.model.EmailContext;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {

    private JavaMailSender javaMailSender;

    private MailContentBuilder mailContentBuilder;

    @Async
    void sendEmail(EmailContext context){
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom("phnxdrone@gmail.com");
            mimeMessageHelper.setTo(context.getRecipient());
            mimeMessageHelper.setSubject(context.getSubject());
            mimeMessageHelper.setText(context.getBody());
        };
        try{
            javaMailSender.send(mimeMessagePreparator);
            log.info("Mail sent to : "+ context.getRecipient());
        }catch (MailException me){
            throw new ApplicationException("Exception while sending mail to : "+ context.getRecipient(), me);

        }
    }
}
