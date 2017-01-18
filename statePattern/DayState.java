package statePattern;

public class DayState implements State{
	private static DayState singleton = new DayState();
	private DayState(){
		
	}
	
	public static DayState getInstance(){
		return singleton;
	}
	
	@Override
	public void doClock(Context context, int hour) {
		// TODO Auto-generated method stub
		if(hour < 9 || 17 <= hour){
			context.changeState(NightState.getInstance());
		}
	}

	@Override
	public void doUse(Context context) {
		// TODO Auto-generated method stub
		context.recordLog("Use money DayLight.");
	}

	@Override
	public void doAlarm(Context context) {
		// TODO Auto-generated method stub
		context.callSecurityCenter("Use alarm DayLight.");
	}

	@Override
	public void doPhone(Context context) {
		// TODO Auto-generated method stub
		context.callSecurityCenter("Use phone DayLight.");
	}
	
	public String toString(){
		return "[DayLight]";
	}
	
}
