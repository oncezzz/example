package a;

import com.zb.UserBean;
import com.zb.UserBeanAuto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/***
 *
 * @author once
 * @date 2020/9/17 0:08
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:aa.xml")
public class ApplicationTest {

    @Autowired
    private UserBean userBean;

    @Autowired(required = false)
    private UserBeanAuto userBeanAuto;

    @Test
    public void runTes() {
        userBean.print();
        if (userBeanAuto != null) {
            userBeanAuto.print();
        }
    }
}
