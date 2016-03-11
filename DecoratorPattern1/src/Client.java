
public class Client {
	public static void main(String[] args){
		Person p = new Boy();
		
		System.out.println("=============穿个贵衣服===============");
		Person ep = new ExpensiveCloth(p);
		ep.dressed();
		System.out.println("=============穿个便宜的衣服================");
		Person cp = new CheapCloth(p);
		cp.dressed();
		}
}
