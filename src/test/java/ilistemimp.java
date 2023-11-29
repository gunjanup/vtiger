import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.crm.VtigerPractice.ItestListenerimp.class)
public class ilistemimp {
	@Test
	public void execute()
	{
		Assert.fail();
	System.out.println("hi");	
	}
	

}
