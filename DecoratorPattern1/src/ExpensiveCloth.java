
public class ExpensiveCloth extends PersonCloth{

	public ExpensiveCloth(Person mPerson) {
		super(mPerson);
	}
	@Override
	public void dressed() {
		super.dressed();
		dresseShirt();
		dresseLeather();
		dresJean();
	}
	
	private void dresseShirt(){
		System.out.println("穿短袖");
	}

	private void dresseLeather(){
		System.out.println("穿条皮衣");
	}
	private void dresJean(){
		System.out.println("穿条牛仔裤");
	}
}
