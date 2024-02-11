package zuci.rms.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import zuci.rms.deo.RestaurantDeo;
import zuci.rms.model.Restaurant;

public class SearchRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  Restaurant restaurant=RestaurantDeo.getRestaurantById(Integer.parseInt(request.getParameter("id")));
		  RequestDispatcher rd=request.getRequestDispatcher("displayRestaurant.jsp");
			request.setAttribute("rest", restaurant);
			rd.forward(request, response);
	}
}
