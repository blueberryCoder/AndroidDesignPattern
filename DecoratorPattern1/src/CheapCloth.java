
public class CheapCloth extends PersonCloth{

	public CheapCloth(Person mPerson) {
		super(mPerson);
	}
	@Override
	public void dressed() {
		super.dressed();
		dressShorts();
	}
	public void dressShorts(){
		System.out.println("穿条短裤");
	}
}
