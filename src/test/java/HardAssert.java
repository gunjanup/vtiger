import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
@Test
public void HardAssert()
{
	System.out.println("hi");
Assert.assertEquals("a","b");	
System.out.println("bye");
}
@Test
public void SoftAssert()
{
	org.testng.asserts.SoftAssert sa=new org.testng.asserts.SoftAssert();
	Assert.assertEquals("a", "a");
	System.out.println("hi");
	sa.assertEquals("a","b");
	
	sa.assertTrue(false);
	System.out.println("bye");
	sa.assertAll();
	
}
}
