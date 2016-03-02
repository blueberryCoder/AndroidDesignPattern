
/**
 * 备忘录模式
 * @author M.Y.G
 *
 */
public class Client {
	public static void main(String[] args){
		//构建游戏对象
		CallofDuty mCallofDuty = new CallofDuty();
		mCallofDuty.play();
		
		Caretaker caretaker = new Caretaker();
		//游戏存档
		caretaker.archive(mCallofDuty.createMemoto());
		mCallofDuty.quit();
		
		//恢复
		CallofDuty newGame = new CallofDuty();
		newGame.restore(caretaker.getMemoto());
		newGame.play();
	}
}
