import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testannotation {

@BeforeSuite
public void m1()
{
	System.out.println("bs");
}
@BeforeTest
public void m2()
{
	System.out.println("bt");
}
@BeforeClass
public void m3()
{
	System.out.println("bc");
}
@BeforeMethod 
public void m4()
{
	System.out.println("bm");
}
@Test
public void t1()
{
	System.out.println("t1");
}
@Test
public void  t2()
{
	System.out.println("t2");
}
@AfterMethod
public void am()
{
	System.out.println("one");
}
@AfterClass
public void ac()
{
	System.out.println("ac");
}
@AfterTest
public void at()
{
	System.out.println("at");
}
@AfterSuite
public void as()
{
	System.out.println("as");
}
	
}
