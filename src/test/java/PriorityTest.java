import static org.testng.Assert.fail;

import org.testng.annotations.Test;
//default priority=0
public class PriorityTest {

	@Test(priority = -2)
	public void CreateCustomer()
	{
		System.out.println("one");
	}
	
	@Test(priority = -1,dependsOnMethods = "CreateCustomer")
	public void modifyCustomer()
	{
		System.out.println("two");
	}
	@Test(dependsOnMethods = "modifyCustomer")
	
	public void deleteCustomer()
	{
	System.out.println("three");	
	}
}
