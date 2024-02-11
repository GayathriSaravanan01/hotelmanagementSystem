package zuci.rms.deo;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import zuci.rms.config.DBUtil;
import zuci.rms.model.Restaurant;

public class RestaurantDeo {
    public static Restaurant getRestaurantById(int id) {
        Restaurant restaurant=null;
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.getMessage();
		}
        try(Connection connection= DriverManager.getConnection(DBUtil.URL, DBUtil.USERNAME,DBUtil.PASSWORD);
            PreparedStatement pstmt=connection.prepareStatement("SELECT * FROM restaurant WHERE id=?;");){
            pstmt.setInt(1,id);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
                restaurant=new Restaurant();
                restaurant.setRestaurantId(rs.getInt(1));
                restaurant.setRestaurantName(rs.getString(2));
                restaurant.setRestaurantAddress(rs.getString(3));
                restaurant.setRestaurantPhone(rs.getLong(4));
                restaurant.setRestaurantDeo(rs.getDate(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return restaurant;
    }

    public static boolean updateRestaurantNameById(String restaurantName,int id) {
    	boolean flag=false;
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.getMessage();
		}
        String query="UPDATE restaurant SET name=? WHERE id=?";
        try (Connection connection=DriverManager.getConnection(DBUtil.URL, DBUtil.USERNAME,DBUtil.PASSWORD);
             PreparedStatement pstmt=connection.prepareStatement(query);){
            pstmt.setString(1,restaurantName);
            pstmt.setInt(2,id);
            int status=pstmt.executeUpdate();
            if(status!=0) {
            	flag=true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }
    public static boolean deleteRestaurantById(int idDelete) {
    	boolean flag=false;
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.getMessage();
		}
        try(Connection connection=DriverManager.getConnection(DBUtil.URL, DBUtil.USERNAME,DBUtil.PASSWORD);
            PreparedStatement pstmt=connection.prepareStatement("DELETE FROM restaurant WHERE id=?;");) {
            pstmt.setInt(1,idDelete);
            int status=pstmt.executeUpdate();
            if(status!=0) {
            	flag=true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  flag;
    }

    public static List<Restaurant> getAllRestaurant() {
        List<Restaurant> alist=new LinkedList<>();
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.getMessage();
		}
        Restaurant restaurant=null;
        try(Connection connection=DriverManager.getConnection(DBUtil.URL, DBUtil.USERNAME,DBUtil.PASSWORD);
            PreparedStatement pstmt=connection.prepareStatement("SELECT * FROM restaurant");){
            ResultSet rs=pstmt.executeQuery();

            while(rs.next()){
                restaurant=new Restaurant();
                restaurant.setRestaurantId(rs.getInt(1));
                restaurant.setRestaurantName(rs.getString(2));
                restaurant.setRestaurantAddress(rs.getString(3));
                restaurant.setRestaurantPhone(rs.getLong(4));
                restaurant.setRestaurantDeo(rs.getDate(5));
                alist.add(restaurant);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alist;
    }

    public static boolean addNewRestaurant(Restaurant restaurant) {
    	boolean flag=false;
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.getMessage();
		}
    	try(
    		Connection connection=DriverManager.getConnection(DBUtil.URL, DBUtil.USERNAME, DBUtil.PASSWORD);
            Statement stmt=connection.createStatement();) {
            int status = stmt.executeUpdate("INSERT INTO restaurant VALUES("+restaurant.getRestaurantId()+",'"+restaurant.getRestaurantName()+"','"+restaurant.getRestaurantAddress()+"',"+restaurant.getRestaurantPhone()+",'"+new Date((restaurant.getRestaurantDeo()).getTime())+"')");
            if(status!=0) {
            	flag=true;
            }
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    	return flag;
    }
}

