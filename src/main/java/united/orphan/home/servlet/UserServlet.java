package united.orphan.home.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import united.orphan.home.model.ChildInformation;
import united.orphan.home.model.Orphanage;
import united.orphan.home.service.UserService;


@WebServlet(
		description = "This servlet acts as a controller by accepting every request", 
		urlPatterns = { 
				"/UserPageDemo", 
				"/UserPage",
				"/Click"
		})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	public void init() {

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("uri: "+action);
		HttpSession session=request.getSession();
		try {
			if(session.getAttribute("role")==null) {
				request.getRequestDispatcher("HomePage").forward(request, response);
			}else {
				switch (action) {
				case "/Click":
					listChild(request,response);
					break;
				default:
					listOrphanage(request,response);
					break;
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
		
	}
	
	private void listOrphanage(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		UserService orphanage=new UserService();
		
		List<Orphanage> listOrphanage = orphanage.selectAllOrphanage();	
		request.setAttribute("listOrphanage", listOrphanage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("showAllOrphanage.jsp");
		dispatcher.forward(request, response);
	}


	private void listChild(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		UserService child=new UserService();
		
		String id = (request.getParameter("id"));
		List<ChildInformation> listChild = child.selectAllOrphanageChild(id);
		
		request.setAttribute("listChild", listChild);
		RequestDispatcher dispatcher = request.getRequestDispatcher("showAllChild.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
