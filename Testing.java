import java.*;
public class Testing
{
	public static void main (String args[])
	{
		System.out.println("hi");

		for(int i=0;i<100;i++)
			System.out.println((int)(Math.random()*7));


		String binary = "111";

		
		binary = binary.substring(0,2) + "0" + binary.substring(2+1,3);
		System.out.println(binary);
	}
}