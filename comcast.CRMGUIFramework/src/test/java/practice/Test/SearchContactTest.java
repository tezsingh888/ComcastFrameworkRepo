package practice.Test;
/**
 * test class for contact module
 * @author Tej singh
 */

import org.testng.annotations.Test;

import com.comCast.crm.ObjectRepositoryUtility.LoginPage;
import com.comCast.crm.basetest.BaseClass;

public class SearchContactTest extends BaseClass {
	/**
	 * Scenario: login()==> navigateContact==>createcontact()==verify
	 */
@Test
public void searchcontactTest() {
	/*
	 *step1:login to app
	 */
	LoginPage lp=new LoginPage(driver);
	lp.loginTOApp("url", "username","password");
}
}
