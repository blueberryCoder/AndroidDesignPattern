import java.util.LinkedList;
import java.util.List;


public class BusinessReport {
	List<Staff> mStaffs = new LinkedList<Staff>();
	public BusinessReport(){
		mStaffs.add(new Manager("王经理"));
		mStaffs.add(new Engineer("工程师-Shawn.Xiong"));
		mStaffs.add(new Engineer("工程师-Kael"));
		mStaffs.add(new Engineer("工程师-Chaossss"));
		mStaffs.add(new Engineer("工程师-Tiiime"));
	}
	
	public void showReport(Visitor visitor){
		for(Staff staff:mStaffs){
			staff.accept(visitor);
		}
	}
}
