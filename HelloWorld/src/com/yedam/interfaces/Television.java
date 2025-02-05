package com.yedam.interfaces;

public class Television implements RemoteControl{
	
	@Override
	public void turnOff() {
		System.out.println("TV의 전원을 끕니다.");
		
	}
	@Override
	public void turnOn() {
		System.out.println("TV의 전원을 켭니다.");
		
	}
}
