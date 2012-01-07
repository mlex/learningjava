package de.port8000.resthelloworld;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorld {
	
	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jersey";
	}
	
	// This method is called if XML is request
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}

	// This method is called if HTML is request
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello(@Context HttpServletRequest req) {
		

        HttpSession session= req.getSession(true);
        Object foo = session.getAttribute("foo");
        String add;
        if (foo!=null) {
        	session.setAttribute("foo", foo.toString() + "!");
        	add = foo.toString();
        } else {
            session.setAttribute("foo", "!");
            add = "";
        }

		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + "Hello Jersey" + add + "</body></h1>" + "</html> ";
	}
}
