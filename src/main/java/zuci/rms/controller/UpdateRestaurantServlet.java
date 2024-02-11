package zuci.rms.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import zuci.rms.deo.RestaurantDeo;

public class UpdateRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean status=RestaurantDeo.updateRestaurantNameById(request.getParameter("name"),Integer.parseInt(request.getParameter("id")));
		response.getWriter().append("Served at: ").append(""+status);
	}
}