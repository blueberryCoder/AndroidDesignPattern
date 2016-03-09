package com.bluberry.adpater;

import com.bluberry.adpater.class_adapter.Adapter;
import com.bluberry.adpater.object_adapter.Volt220;

public class Client {
	public static void main(String[] args){
		
		
		System.out.println("类适配器模式======================");
		System.out.println("getVolet5 = "+new Adapter().getVolt5());
		
		System.out.println("对象适配器模式===================");
		System.out.println("getVolet5= "+new com.bluberry.adpater.object_adapter.Adapter(new Volt220()).getVolt5());
	}
}
