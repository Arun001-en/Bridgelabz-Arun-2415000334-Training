package Inheritance;

class Order{
	int orderId;
	String orderDate;
	Order(int orderId, String orderDate){
		this.orderId= orderId;
		this.orderDate= orderDate;
	}
	public void getOrderStatus(){
		System.out.println("Order status: ");
		System.out.println("orderId: "+orderId);
		System.out.println("orderDate: "+orderDate);
		System.out.println();
	}
	
}
class ShippedOrder extends Order{
	int trackingNumber;
	ShippedOrder(int orderId, String orderDate,int trackingNumber){
		super(orderId, orderDate);
		this.trackingNumber=trackingNumber;
	}
	public void getOrderStatus(){
		System.out.println("ShippedOrder status: ");
		System.out.println("orderId: "+orderId);
		System.out.println("orderDate: "+orderDate);
		System.out.println("trackingNumber: "+trackingNumber);
		System.out.println();
		
	}
}
class DeliveredOrder extends ShippedOrder{
	String deliveryDate;
	DeliveredOrder(int orderId, String orderDate,int trackingNumber,String deliveryDate){
		super(orderId, orderDate,trackingNumber);
		this.deliveryDate=deliveryDate;
	}
	public void getOrderStatus(){
		System.out.println("DeliveredOrder status: ");
		System.out.println("orderId: "+orderId);
		System.out.println("orderDate: "+orderDate);
		System.out.println("trackingNumber: "+trackingNumber);
		System.out.println("deliveryDate: "+deliveryDate);
		System.out.println();
		
		
	}
}


public class OnlineRetail {


	public static void main(String[] args) {
		Order[] order = new Order[3];
		order[0]=new Order(123,"01/12/2000");
		order[1]=new ShippedOrder(123,"01/12/2000",234);
		order[2]=new DeliveredOrder(123,"01/12/2000",234,"12/12/2000");
		
		for(Order or:order) {
			or.getOrderStatus();
		}
		
		

	}

}