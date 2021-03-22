
class ItemSeparator {
	    private String name;
	    private double price;
	    private int quantity;
	    public ItemSeparator(String raw) {
	    	this.name = raw.substring(0, raw.indexOf('$'));
	    	String price = raw.substring(raw.indexOf(name) + name.length() + 4, 
	    			raw.indexOf('$', raw.indexOf(name) + name.length() + 4));
	    	try {
	    		this.price = Double.parseDouble(price);
	    	}catch (RuntimeException e) {
	    		price = raw.substring(raw.indexOf(price) + 5, 
		    			raw.indexOf('$', raw.indexOf(price) + 5));
	    		
	    	}
	    	 quantity = Integer.parseInt(raw.substring(raw.indexOf(price) + price.length() + 4, 
	    			raw.length()));
	    }
		public String getName() {
			return name;
		}
		public int getQuantity() {
			return quantity;
		}
		public double getPrice() {
			return price;
		}
	    
	}
public class Solution3 {
	
	
	public static void main(String[] args) {
		ItemSeparator itemSeparator = new ItemSeparator("Pencil$ Box$$##12.60$$##80");
		System.out.println(itemSeparator.getPrice());
	}
}
