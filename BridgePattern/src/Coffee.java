/**
 * 桥接模式
 * 抽象部分
 * @author M.Y.G
 *
 */
public abstract class Coffee {
	protected CoffeeAdditives impl ;
	public Coffee(CoffeeAdditives impl){
		this.impl = impl;
		
	}
	/**
	 * 咖啡具体是什么样子由子类决定
	 */
	public abstract void makeCoffee();
}
