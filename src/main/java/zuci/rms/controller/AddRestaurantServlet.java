package zuci.rms.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import zuci.rms.deo.RestaurantDeo;
import zuci.rms.model.Restaurant;

public class AddRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Restaurant restaurant=new Restaurant();
		restaurant.setRestaurantId(Integer.parseInt(request.getParameter("id")));
		restaurant.setRestaurantName(request.getParameter("name"));
		restaurant.setRestaurantAddress(request.getParameter("address"));
		restaurant.setRestaurantPhone(Long.parseLong(request.getParameter("phone")));	
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			restaurant.setRestaurantDeo(sdf.parse(request.getParameter("deo")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       boolean status=RestaurantDeo.addNewRestaurant(restaurant);
		
		response.getWriter().append("Served at: ").append(""+status);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
