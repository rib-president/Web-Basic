package practice_4.Question08.Q18;

public class ShopService {
	private static ShopService shopService = new ShopService();
	
	private ShopService() {
		
	}
	
	static ShopService getInstance() {
		return shopService;
	}
}
