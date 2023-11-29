import org.testng.annotations.Test;

public class SmokeRegGroup {
@Test(groups="smoke")
public void smoke()
{
	System.out.println("smoke");
}
@Test(groups= {"smoke","regression"})
public void smokereg()
{
	System.out.println("smokereg");
}
@Test()
public void normal()
{
	System.out.println("normal");
}
}
