
public interface Iterator<T> {
	
	/**
	 * 是否還有下一個元素
	 * @return
	 */
	boolean hasNext();
	
	T next();
}
