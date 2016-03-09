package com.bluberry.adpater.object_adapter;

public class Adapter implements Target{
	
	private Volt220 volt220 ;
	public Adapter(Volt220 volt220) {
	this.volt220 = volt220;	
	}

	@Override
	public int getVolt5() {
		return 5;
	}

	public int getVolt220(){
		return volt220.getVolt220();
	}
}
