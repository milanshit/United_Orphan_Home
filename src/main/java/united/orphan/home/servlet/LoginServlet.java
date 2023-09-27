package united.orphan.home.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import united.orphan.home.model.Orphanage;
import united.orphan.home.model.Users;
import united.orphan.home.service.LoginService;


@WebServlet(
		description = "This servlet acts as a controller by accepting every request", 
		urlPatterns = { 
				"/HomePageDemo", 
				"/HomePage",
				"/LoginPage",
				"/User",
				"/Orphanage",
				"/UserRegister",
				"/OrphanageRegister",
				"/UserRegisterForm",
				"/OrphanageRegisterForm",
				"/Logout"
				
		})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static LoginService loginservice;
	
	public void init() {
		loginservice=new LoginService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getServletPath();
		HttpSession session=request.getSession();
		
		System.out.println("uri: "+action);
		
		try {
			System.out.print(session.getAttribute("role"));
				switch (action) {
				case "/User":
					session.setAttribute("role", "user");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					break;
				case "/Orphanage":
					session.setAttribute("role", "orphanage");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					break;
				case "/LoginPage":
					login(request, response);
					break;
				case "/UserRegisterForm":
					request.getRequestDispatcher("userRegister.jsp").forward(request, response);
					break;
				case "/OrphanageRegisterForm":
					request.getRequestDispatcher("orphanageRegister.jsp").forward(request, response);
					break;
				case "/UserRegister":
					userRegister(request, response);
					break;
				case "/OrphanageRegister":
					orphanageRegister(request, response);
					break;
				case "/Logout":
		            session.invalidate();
		            request.getRequestDispatcher("HomePage").forward(request, response);
					break;
				case "/HomePage":
					request.getRequestDispatcher("home.jsp").forward(request, response);
					break;
				}
		}catch (Exception ex) {
			throw new ServletException(ex);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email= request.getParameter("email");
		String password= request.getParameter("password");
		HttpSession session=request.getSession();
		
		if(session.getAttribute("role").equals("user")) {
			Users user=new Users();
			try {
				user=loginservice.validateUser(email,password);
				if(user.getStatus()) {
					session.setAttribute("user_id", user.getId());
					session.setAttribute("user_name", user.getName());
					RequestDispatcher rd=request.getRequestDispatcher("UserPage");
					rd.forward(request, response);
				}else {
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}catch(Exception e) {
				System.out.print(e);
			}
		}else {
			try {
				Orphanage orphanage=new Orphanage(); 
				orphanage=loginservice.validateOrphanage(email,password);
				if(orphanage.getStatus()) {
					System.out.print(orphanage.getId());
					session.setAttribute("orphanage_id", orphanage.getId());
					session.setAttribute("orphanage_name", orphanage.getName());
					RequestDispatcher rd=request.getRequestDispatcher("OrphanagePage");
					rd.forward(request, response);
				}else {
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}catch(Exception e) {
				System.out.print(e);
			}
		}
		
	}
	
	private void userRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users user=new Users();
		String gender;
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setPhone_number(request.getParameter("phone_number"));
	
		if(request.getParameter("gender").equals("1")) {
			gender="male";
		}else if(request.getParameter("gender").equals("2")) {
			gender="female";
		}else {
			gender="other";
		}
		
		user.setGender(gender);
		user.setCountry(request.getParameter("country"));
		user.setState(request.getParameter("state"));
		user.setCity(request.getParameter("city"));
		
		try {
			if(loginservice.registerUser(user)) {
				HttpSession session=request.getSession();
				session.setAttribute("user_id", user.getId());
				session.setAttribute("user_name", user.getName());
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("userRegister.jsp").forward(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	protected void orphanageRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Orphanage orphanage=new Orphanage();
		
		orphanage.setName(request.getParameter("name"));
		orphanage.setRegistration_id(request.getParameter("registration_id"));
		orphanage.setEmail(request.getParameter("email"));
		orphanage.setPhone_number_1(request.getParameter("phone_number_1"));
		orphanage.setPhone_number_2(request.getParameter("phone_number2"));
		orphanage.setPassword(request.getParameter("password"));
		orphanage.setAddress(request.getParameter("address"));
		orphanage.setCountry(request.getParameter("country"));
		orphanage.setState(request.getParameter("state"));
		orphanage.setCity(request.getParameter("city"));
		orphanage.setDescription(request.getParameter("description"));
		System.out.print(orphanage.getDescription());
		try {
			if(loginservice.registerOrphanage(orphanage)) {
				HttpSession session=request.getSession();
				session.setAttribute("orphanage_id", orphanage.getId());
				session.setAttribute("orphanage_name", orphanage.getName());
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("orphanageRegister.jsp").forward(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
