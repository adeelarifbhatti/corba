package Server;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import HelloApp.Hello;
import HelloApp.HelloHelper;

public class HelloServer {
public static void main(String[] args) {
	try {
		ORB orb = ORB.init(args, null);
		POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		rootpoa.the_POAManager().activate();
		
		HelloServant helloImpl = new HelloServant();
		org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
		Hello href=HelloHelper.narrow(ref);
		
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		
		String name ="Hello";
		NameComponent path[] = ncRef.to_name(name);
		ncRef.rebind(path, href);
		orb.run();
		
	} catch(Exception e) {
		System.err.println("Error:" + e.getMessage());
		e.printStackTrace(System.out);
	}
}
}
