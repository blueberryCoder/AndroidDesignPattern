
public class Client {
	public static void main(String[] args){
		System.out.println("========【裝飾器1】===========");
		Component decoratorA = new ConcreteDecoratorA(new ConcreteCompent());
		decoratorA.operate();
		System.out.println("==========【裝飾器2】============");
		Component decoratorB = new ConcreteDecoratorB(decoratorA);
		decoratorB.operate();
		
	}
}
