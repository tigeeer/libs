package test.wangjx.common.util;

import com.wangjx.common.util.RegexUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/10/17
 * Time: 16:11
 */
public class RegexUtilTest {

    @Test
    public void mobile() {
        Assert.assertTrue(RegexUtil.mobile("13522132289"));
    }

    @Test
    public void email() {
        Assert.assertTrue(RegexUtil.email("1606088706@qq.com"));
    }
}
