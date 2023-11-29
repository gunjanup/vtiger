import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DTpractice {
	
	@Test(dataProvider = "getData")
	public void data(String fname,String lastname)
	{
	System.out.println(fname+"-----"+lastname);	
	}
	
	@DataProvider
	public Object[][] getData()
	{
	Object[][] obj=new Object[2][2];
	obj[0][0]="gunjan";
	obj[0][1]="prasad";
	
	obj[1][0]="nisu";
	obj[1][1]="sharma";
	
	
	
	return obj;
	}

}
