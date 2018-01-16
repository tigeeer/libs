package com.wangjx.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/11/8
 * Time: 10:43
 */
public class MailFactory {

    public final static String MAIL_SMTP_AUTH = "mail.smtp.auth";
    public final static String MAIL_SMTP_HOST = "mail.smtp.host";
    public final static String MAIL_USER = "mail.user";
    public final static String MAIL_PASSWORD = "mail.password";

    private MailSource mailSource;

    public MailFactory(MailSource mailSource) {
        this.mailSource = mailSource;
    }

    public Session getSession() {
        final Properties props = new Properties();
        props.put(MAIL_SMTP_AUTH, true);
        props.put(MAIL_SMTP_HOST, mailSource.getSmtp());
        props.put(MAIL_USER, mailSource.getUser());
        props.put(MAIL_PASSWORD, mailSource.getPassword());

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String userName = props.getProperty(MAIL_USER);
                String password = props.getProperty(MAIL_PASSWORD);
                return new PasswordAuthentication(userName, password);
            }
        };

        return Session.getInstance(props, authenticator);
    }
}
