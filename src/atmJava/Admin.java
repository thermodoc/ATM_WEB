package atmJava;



public class Admin {
	public static boolean isAdmin(String adminUser ,String adminPass)
	{	
		if(adminUser.equalsIgnoreCase("admin")&&adminPass.equals("admin"))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}
