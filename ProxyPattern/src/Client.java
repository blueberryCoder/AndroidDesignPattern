import java.lang.reflect.Proxy;

import com.proxy.ILawsuit;
import com.proxy.XiaoMin;
import com.proxy.dynamicproxy.DynamicProxy;
import com.proxy.staticproxy.Lawyer;


public class Client {
	public static void main(String[] args)
	{
//		callStaticProxy();
		callDynamicProxy();
	}

	private static void callDynamicProxy() {
		ILawsuit xiaomin = new XiaoMin();
		DynamicProxy proxy = new DynamicProxy(xiaomin);
		ClassLoader loader = xiaomin.getClass().getClassLoader();
		ILawsuit lawyer = (ILawsuit) Proxy.newProxyInstance(loader, new Class[]{ILawsuit.class}, proxy);
		lawyer.submit();
		lawyer.burden();
		lawyer.defend();
		lawyer.finish();
	}

	private static void callStaticProxy() {
		ILawsuit xiaomin = new XiaoMin();
		ILawsuit lawyer= new Lawyer(xiaomin);
		lawyer.submit();
		lawyer.burden();
		lawyer.defend();
		lawyer.finish();
	}
}
