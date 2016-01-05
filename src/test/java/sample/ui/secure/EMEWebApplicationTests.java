package sample.ui.secure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.huihuan.eme.EMEWebApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(EMEWebApplication.class)
@WebIntegrationTest(randomPort = true)
@DirtiesContext
public class EMEWebApplicationTests {

	@Test
	public void testHome() throws Exception {
		
	}


}
