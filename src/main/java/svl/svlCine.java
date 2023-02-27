package svl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class svlCine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public svlCine() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("ISO-8859-1");
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id"); 
		Object data = null;
		if ( id != null) {
			if ( id.equals("Cine") || id.equals("Cines") )  
			data = new dao.CineDAO().getCines(3, true);
			else data = new dao.CineDAO().getCine( id, true );
			session.setAttribute("id", data == null ? null : id.equals("Cine") || id.equals("estrenos") ? "peliculas": "pelicula" );
			session.setAttribute("data", data);
		}
		
		response.sendRedirect("index.jsp");
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
