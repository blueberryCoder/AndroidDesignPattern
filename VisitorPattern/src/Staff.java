import java.util.Random;

//员工基类
public abstract class Staff {
	public String name;
	
	public int kpi;
	
	public Staff(String aName){
		this.name = aName;
		this.kpi = new Random().nextInt(10);
	}
	
	public abstract void accept(Visitor visitor);
}
