import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryLogic {

	
	@Test(retryAnalyzer = com.crm.VtigerPractice.RetryAnalyzer.class)
	public void Test()
	{
		Assert.assertEquals(false,true);
	}
	
	@Test(retryAnalyzer = com.crm.VtigerPractice.RetryAnalyzer.class)
	
	public void Test2()
	{
		Assert.assertEquals(false,true);
	}
	
}
