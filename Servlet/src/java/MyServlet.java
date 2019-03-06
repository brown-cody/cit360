import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

    String firstName;
    String lastName;
    long zip;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        		PrintWriter pw = response.getWriter();
		
		firstName = request.getParameter("firstName");
		lastName = request.getParameter("lastName");
		zip = Long.parseLong(request.getParameter("zip"));
		
		UserInfo newUser = new UserInfo();
		newUser.setUserInfo(firstName, lastName, zip);
		
		pw.println("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset='ISO-8859-1'>"
				+ "<title>Test Servlet</title>"
				+ "<link rel='stylesheet' type='text/css' href='/newServlet/style.css'>"
				+ "</head>"
				+ "<body>"
				+ "<h2>Congrats!</h2>"
				+ "<p>Java Object \"newUser\" created from user data using this servlet."
				+ "<p>Data below referenced from Java Object.</p>"
				+ "<h2>Info Entered:</h2>");
		pw.println("<p>First Name: " + newUser.getFirstName() + "</p><p>Last Name: " + newUser.getLastName() + "</p><p>Zip Code: " + newUser.getZip());
		pw.println("</body>"
				+ "</html>");
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
