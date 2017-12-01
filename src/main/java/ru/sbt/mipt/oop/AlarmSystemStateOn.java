package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.AlarmSystemStateEnum.ON;

/**
 * Created by user17 on 17.11.2017.
 */
public class AlarmSystemStateOn implements AlarmSystemState {

	private final AlarmSystem alarmSystem;

	public AlarmSystemStateOn(AlarmSystem alarmSystem) {
		this.alarmSystem = alarmSystem;
	}
	@Override
	public AlarmSystemStateEnum getState() {
		return ON;
	}

	@Override
	public void turnOn() {

	}

	@Override
	public void turnOff() {

	}

	@Override
	public void onEvent(SensorEvent sensorEvent) {
		//todo
//		alarmSystem.setAlarmSystem();
	}
}