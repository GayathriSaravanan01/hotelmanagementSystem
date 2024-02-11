package zuci.rms.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import zuci.rms.deo.RestaurantDeo;
import zuci.rms.model.Restaurant;
public class ShowRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Restaurant> list=RestaurantDeo.getAllRestaurant();
		RequestDispatcher rd=request.getRequestDispatcher("allrestaurant.jsp");
		request.setAttribute("rest", list);
		rd.forward(request, response);
	}
}
