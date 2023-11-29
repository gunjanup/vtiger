import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider = "storeRedBusData")
	public void getdata(String form,String to,int price)
	{
		System.out.println(form+"----"+to+"-----"+price);
	}
	@DataProvider
	public Object[][] storeRedBusData()
	{
		//1 set of data           //2 =set of data //3=no of columns
		Object[][] obj=new Object[2][3];
		obj[0][0]="kolkatta";
		obj[0][1]="malda";
		obj[0][2]=700;
		//2 set of data ......//
		obj[1][0]="malda";
		obj[1][1]="digha";
		obj[1][2]=8989;
		return obj;
		
		
	}
}
