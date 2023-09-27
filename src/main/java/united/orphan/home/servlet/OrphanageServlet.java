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
import united.orphan.home.service.OrphanageService;
import united.orphan.home.service.UserService;


@WebServlet(
		description = "This servlet acts as a controller by accepting every request", 
		urlPatterns = { 
				"/OrphanagePageDemo", 
				"/OrphanagePage",
				"/AddChild",
				"/AddChildPage",
				"/UpdateChildPage",
				"/UpdateChild",
				"/DeleteChild"
		})
public class OrphanageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrphanageService new_child=new OrphanageService();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		HttpSession session=request.getSession();
		
		System.out.println("uri: "+action);
		
		try {
			if(session.getAttribute("role")==null) {
				request.getRequestDispatcher("HomePage").forward(request, response);
			}else {
				switch (action) {
				case "/AddChild":
					addChild(request, response);
					break;
				case "/UpdateChild":
					updateChild(request, response);
					break;
				case "/UpdateChildPage":
					showChildById(request, response);
					break;
				case "/DeleteChild":
					deleteChild(request, response);
					break;
				case "/AddChildPage":
					session.setAttribute("action", "add");
					RequestDispatcher dispatcher = request.getRequestDispatcher("childInformation.jsp");
					dispatcher.forward(request, response);
					break;
				
				default:
					listChild(request,response);
					break;
				}
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	
	private void listChild(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		UserService child=new UserService();
		HttpSession session=request.getSession();
		
		String id = (String) session.getAttribute("orphanage_id");
		
		List<ChildInformation> listChild = child.selectAllOrphanageChild(id);
		
		request.setAttribute("listChild", listChild);
		RequestDispatcher dispatcher = request.getRequestDispatcher("orphanageInformation.jsp");
		dispatcher.forward(request, response);
	}
	
	private void deleteChild(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		HttpSession session=request.getSession();
		
		String orphanage_id = (String) session.getAttribute("orphanage_id");
		
		String child_id=request.getParameter("id");
		
		if(new_child.selectAllOrphanageChild(orphanage_id,child_id)) {
			System.out.print("1 row delete ");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("OrphanagePage");
		dispatcher.forward(request, response);
	}
	
	
	protected void addChild(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChildInformation child=new ChildInformation();
		HttpSession session=request.getSession();
		
		System.out.print((String) session.getAttribute("orphanage_id"));
		child.setOrphanage_id((String) session.getAttribute("orphanage_id"));
		child.setName(request.getParameter("name"));
		int age=Integer.parseInt(request.getParameter("age"));
		child.setAge(age);
		child.setDob(request.getParameter("dob"));
		String gender="";
		if(request.getParameter("gender").equals("1")) {
			gender="male";
		}else if(request.getParameter("gender").equals("2")) {
			gender="female";
		}else {
			gender="other";
		}
		
		child.setGender(gender);
		child.setReligion(request.getParameter("religion"));
		String physically_disable="";
		if(request.getParameter("physically_disable").equals("1")) {
			physically_disable="Yes";
		}else if(request.getParameter("physically_disable").equals("2")) {
			physically_disable="No";
		}	
		child.setPhysically_disable(physically_disable);
		System.out.print(child.getAge());
		
		try {
			if(new_child.addChildInformation(child)) {
				System.out.print("1 row insert");
			}
		}catch(Exception e) {
			System.out.print(e);
		}request.getRequestDispatcher("OrphanagePage").forward(request, response);
	}
	
	protected void updateChild(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChildInformation child=new ChildInformation();
		HttpSession session=request.getSession();
		
		System.out.print((String) session.getAttribute("orphanage_id"));
		child.setOrphanage_id((String) session.getAttribute("orphanage_id"));
		child.setChild_id(request.getParameter("id"));
		child.setName(request.getParameter("name"));
		int age=Integer.parseInt(request.getParameter("age"));
		child.setAge(age);
		child.setDob(request.getParameter("dob"));
		String gender="";
		if(request.getParameter("gender").equals("1")) {
			gender="male";
		}else if(request.getParameter("gender").equals("2")) {
			gender="female";
		}else {
			gender="other";
		}
		
		child.setGender(gender);
		child.setReligion(request.getParameter("religion"));
		String physically_disable="";
		if(request.getParameter("physically_disable").equals("1")) {
			physically_disable="Yes";
		}else if(request.getParameter("physically_disable").equals("2")) {
			physically_disable="No";
		}	
		child.setPhysically_disable(physically_disable);
		System.out.print(child.getAge());
		
		try {
			if(new_child.updateChildInformation(child)) {
				System.out.print("1 row insert");
			}
		}catch(Exception e) {
			System.out.print(e);
		}request.getRequestDispatcher("OrphanagePage").forward(request, response);
	}
	
	
	private void showChildById(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		UserService child=new UserService();
		HttpSession session=request.getSession();
		
		String orphanage_id = (String) session.getAttribute("orphanage_id");
		String child_id = (String) request.getParameter("id");
		
		System.out.println(orphanage_id);
		System.out.println(child_id);
		
		ChildInformation new_child = child.selectOrphanageChildById(orphanage_id,child_id);
		request.setAttribute("new_child", new_child);
		System.out.println(new_child.getChild_id());
		System.out.println(new_child.getName());
		System.out.println(new_child.getDob());
		RequestDispatcher dispatcher = request.getRequestDispatcher("childInformation.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
