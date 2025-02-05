package com.yedam.interfaces;
/*
 * 인터페이스 
 * 필드,
 */

public interface RemoteControl {
   public int MAX_VOLUM = 10; //상수
   
   public void turnOn(); //추상메서드(기능정의)
   
   public void turnOff();
}
