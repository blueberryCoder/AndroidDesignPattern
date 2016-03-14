
public class Client {
	public static void main(String[] args){
		Ordinary implOrdinary = new Ordinary() ;
		Sugar implSugar = new Sugar();
		
		LargeCoffee largeCoffeeOrdinary = new LargeCoffee(implOrdinary);
		largeCoffeeOrdinary.makeCoffee(); 
		
		SmallCoffee smallCoffeeSugar = new SmallCoffee(implSugar);
		smallCoffeeSugar.makeCoffee();
	}
}
