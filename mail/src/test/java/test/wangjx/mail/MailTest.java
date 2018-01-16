package test.wangjx.mail;

import com.wangjx.mail.MailFactory;
import com.wangjx.mail.MailMessage;
import com.wangjx.mail.MailSource;
import com.wangjx.mail.MailTemplate;
import org.junit.Test;

import javax.mail.MessagingException;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/11/8
 * Time: 14:34
 */
public class MailTest {

    @Test
    public void send() {
        MailSource mailSource = new MailSource("smtp.163.com", "18167802828@163.com", "wangjinxu");
        MailFactory mailFactory = new MailFactory(mailSource);
        MailTemplate mailTemplate = new MailTemplate(mailFactory);
        MailMessage mailMessage = new MailMessage("1606088706@qq.com", "hello", "world");

        try {
            mailTemplate.send(mailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
