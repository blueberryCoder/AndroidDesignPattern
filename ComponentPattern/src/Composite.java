import java.util.ArrayList;
import java.util.List;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Component
//  @ File Name : Composite.java
//  @ Date : 2016/3/8
//  @ Author : bluberry
//
//




public class Composite extends Component {
	private List<Component> components = new ArrayList<Component>();
	
	public Composite(String name) {
		super(name);
	}

	public void doSomething() {
		System.out.println(name);
		for(Component com:components){
			com.doSomething();
		}
	}
	
	public void addChild(Component component) {
		components.add(component);
	}
	
	
	
	public Component getChild(int pos) {
		return components.get(pos);
	}
	
	public void remoteChild(Component component) {
		components.remove(component);
	}
}