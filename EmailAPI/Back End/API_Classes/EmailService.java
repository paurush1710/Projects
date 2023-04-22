package com.email.service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

@Service
public class EmailService {

    public boolean sendEmail(String subject, String message, String to){
        boolean flag = false;
        String from = "from_email_address";

        String host = "smtp.gmail.com";

        // Set the system properties
        Properties properties = System.getProperties();
        System.out.println("Properties : "+properties);

        //Setting important information to properties object


        //host set
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        // Step 1 : Get the session Object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("from_email_address","passcode_generated_from_google");
            }
        });

        session.setDebug(true);

        // Step 2 : Compose the Message [text, Attachment or multimedia]

        MimeMessage mimeMessage = new MimeMessage(session);


        try {
            //From Email Id
            mimeMessage.setFrom(from);

            //adding recipient to message
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            //adding Subject to message
            mimeMessage.setSubject(subject);

            //adding text to message
//            mimeMessage.setText(message);

            // adding attachment
            // File Path

            String path = "C:\\Users\\pauru\\OneDrive\\Desktop\\virat kohli.jpg";

            MimeMultipart mimeMultipart = new MimeMultipart();
            //text
            //file

            MimeBodyPart textMime = new MimeBodyPart();
            MimeBodyPart fileMime = new MimeBodyPart();


                textMime.setText(message);

                File file = new File(path);
                fileMime.attachFile(file);

                mimeMultipart.addBodyPart(textMime);
                mimeMultipart.addBodyPart(fileMime);


            mimeMessage.setContent(mimeMultipart);

            // SEND

            // STEP 3 : Send the message using Transpport class
            Transport.send(mimeMessage);
            flag = true;
            System.out.println("Sent Success .......");

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

}
