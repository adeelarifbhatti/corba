package HelloApp;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class HelloClient {
	public static void main (String args[]) {
		try {
			ORB orb=ORB.init(args, null);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			String name="Hello";
			Hello helloRef=HelloHelper.narrow(ncRef.resolve_str(name));
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat sdf= new SimpleDateFormat("HH:mm:ss");
			String now = sdf.format(cal.getTime());
			String message = helloRef.sayHello("Hello from Client at :"+ now);
			System.out.println(message);
			
		} 
		catch(Exception e) {
			System.out.println("Hello Client Error"+e.getMessage());
			e.printStackTrace(System.out);
		}
		
		
		
	}

}
