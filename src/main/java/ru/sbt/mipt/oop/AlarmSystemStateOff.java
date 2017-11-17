package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.AlarmSystemStateEnum.OFF;

/**
 * Created by user17 on 17.11.2017.
 */
public class AlarmSystemStateOff implements AlarmSystemState {
	private final AlarmSystem alarmSystem;

	public AlarmSystemStateOff(AlarmSystem alarmSystem) {
		this.alarmSystem = alarmSystem;
	}

	@Override
	public AlarmSystemStateEnum getState() {
		return OFF;
	}

	@Override
	public void turnOn() {
		//dorealwork
		alarmSystem.setAlarmSystemState(new AlarmSystemStateOn(alarmSystem));
	}

	@Override
	public void turnOff() {

	}

	@Override
	public void onEvent(SensorEvent sensorEvent) {

	}
}