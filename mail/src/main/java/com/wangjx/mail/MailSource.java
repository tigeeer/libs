package com.wangjx.mail;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/11/8
 * Time: 14:21
 */
public class MailSource {

    private String smtp;
    private String user;
    private String password;

    public MailSource(String smtp, String user, String password) {
        this.smtp = smtp;
        this.user = user;
        this.password = password;
    }

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
