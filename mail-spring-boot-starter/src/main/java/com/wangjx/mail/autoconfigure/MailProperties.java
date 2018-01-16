package com.wangjx.mail.autoconfigure;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/11/8
 * Time: 10:22
 */
@Configuration
@EnableAutoConfiguration
@PropertySource({"classpath:mail.properties"})
@ConfigurationProperties(prefix = MailProperties.MAIL_PREFIX)
public class MailProperties {
    public static final String MAIL_PREFIX = "mail";

    private String smtp;
    private String user;
    private String password;

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
