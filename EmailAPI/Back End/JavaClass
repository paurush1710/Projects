package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Preparing to send message over Email" );
        String message = "Hello, This message is for security check.";
        String subject = "Confirmation of Email";
        String to = "paurush@gmail.com";
        String from = "dastan@gmail.com";
        
//      sendEmail(message,subject,to,from);
        sendAttach(message,subject,to,from);
    }

    // This is responsble to send the message with attachment
    private static void sendAttach(String message, String subject, String to, String from) {

        // Variable for Gmail host
        String host = "smtp.gmail.com";

        // Set the system properties
        Properties properties = System.getProperties();
        System.out.println("Properties : "+ properties);

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
                return new PasswordAuthentication("dastan@gmail.com","password_generated_from_gmail");
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

            try{
                textMime.setText(message);

                File file = new File(path);
                fileMime.attachFile(file);

                mimeMultipart.addBodyPart(textMime);
                mimeMultipart.addBodyPart(fileMime);

            }
            catch (Exception e){
                e.printStackTrace();
            }

            mimeMessage.setContent(mimeMultipart);

            // SEND

            // STEP 3 : Send the message using Transpport class
            Transport.send(mimeMessage);

            System.out.println("Sent Success .......");

        }
        catch (Exception e){
            e.printStackTrace();
        }




    }

    private static void sendEmail(String message, String subject, String to, String from) {

        // Variable for Gmail host
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
                return new PasswordAuthentication("from_email","password_generated_from_gmail");
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
            mimeMessage.setText(message);

            // SEND

            // STEP 3 : Send the message using Transpport class
            Transport.send(mimeMessage);

            System.out.println("Sent Success .......");

        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
