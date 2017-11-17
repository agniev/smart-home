package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.AlarmSystemStateEnum.OFF;
import static ru.sbt.mipt.oop.AlarmSystemStateEnum.ON;
import static ru.sbt.mipt.oop.AlarmSystemStateEnum.WAIT_FOR_PASSWORD;

/**
 * Created by user17 on 17.11.2017.
 */
public class AlarmSystem implements AlarmSystemState {

	private AlarmSystemState alarmSystemState;

	public AlarmSystem(){
		alarmSystemState = new AlarmSystemStateOff(this);
	}

	@Override
	public AlarmSystemStateEnum getState() {
		return alarmSystemState.getState();
	}

	@Override
	public void turnOn() {
		alarmSystemState.turnOn();
	}

	@Override
	public void turnOff() {
		alarmSystemState.turnOff();
	}

	@Override
	public void onEvent(SensorEvent sensorEvent){
		alarmSystemState.onEvent(sensorEvent);
	}

	public void setAlarmSystemState(AlarmSystemState systemStateEnum) {
		this.alarmSystemState = systemStateEnum;
	}
}