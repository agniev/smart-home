package ru.sbt.mipt.oop;

/**
 * Created by user17 on 17.11.2017.
 */
public interface AlarmSystemState {
	AlarmSystemStateEnum getState();

	void turnOn();

	void turnOff();

	void onEvent(SensorEvent sensorEvent);
}