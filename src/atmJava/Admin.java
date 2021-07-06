package atmJava;



public class Admin {
	public static boolean isAdmin(String adminUser ,String adminPass)
	{	
		try
		{if(adminUser.equalsIgnoreCase("admin")&&adminPass.equals("admin"))
		{
			return true;
		}
		else 
		{
			return false;
		}
		}
		catch (NullPointerException e)
		{
			return false;
		}
	}
}
