package com.wangjx.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/11/8
 * Time: 10:45
 */
public class MailTemplate {

    private MailFactory mailFactory;

    public MailTemplate(MailFactory mailFactory) {
        this.mailFactory = mailFactory;
    }

    public void send(MailMessage mm) throws MessagingException {
        Session session = mailFactory.getSession();
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(session.getProperties().getProperty(MailFactory.MAIL_USER)));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mm.getAddress()));
        message.setSubject(mm.getTitle());
        message.setContent(mm.getContent(), mm.getContentType());

        Transport.send(message);
    }
}
