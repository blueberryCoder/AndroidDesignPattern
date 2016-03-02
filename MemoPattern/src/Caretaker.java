
/**
 * Caretaker
 * @author M.Y.G
 *
 */
public class Caretaker {
	private Memoto mMemoto;
	
	/**
	 * 存档
	 * @param memoto
	 */
	public void archive(Memoto memoto){
		this.mMemoto = memoto;
	}
	
	/**
	 * 读档
	 * @return
	 */
	public Memoto getMemoto(){
	return this.mMemoto;
	}
}
