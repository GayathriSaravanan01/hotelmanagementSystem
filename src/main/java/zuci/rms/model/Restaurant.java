package zuci.rms.model;

import java.util.Date;

public class Restaurant {
	private int restaurantId;
	private String restaurantName;
	private String restaurantAddress;
	private long restaurantPhone;
	private Date restaurantDeo;
	public Restaurant() {
	}
	public Restaurant(int restaurantId, String restaurantName, String restaurantAddress, long restaurantPhone,
			Date restaurantDeo) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.restaurantPhone = restaurantPhone;
		this.restaurantDeo = restaurantDeo;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantAddress() {
		return restaurantAddress;
	}
	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}
	public long getRestaurantPhone() {
		return restaurantPhone;
	}
	public void setRestaurantPhone(long restaurantPhone) {
		this.restaurantPhone = restaurantPhone;
	}
	public Date getRestaurantDeo() {
		return restaurantDeo;
	}
	public void setRestaurantDeo(Date restaurantDeo) {
		this.restaurantDeo = restaurantDeo;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurantAddress=" + restaurantAddress + ", restaurantPhone=" + restaurantPhone
				+ ", restaurantDeo=" + restaurantDeo + "]";
	}
	
	
}
