package com.bluberry.adpater.class_adapter;

public class Adapter extends Volt220 implements FiveVolt{

	@Override
	public int getVolt5() {
		return 5;
	}

}
