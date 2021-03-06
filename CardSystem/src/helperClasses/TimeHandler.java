package helperClasses;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class TimeHandler {

	public TimeHandler(){

	}

	public boolean isWeekday(Calendar date){
		int today = date.get(date.DAY_OF_WEEK);
		if(today==Calendar.SUNDAY || today==Calendar.SATURDAY){
			return false;
		}else{
			return true;
		}
	}

	public boolean isWorkHour(LocalTime timeRightNow){//Test Only	
		if(timeRightNow.isAfter(LocalTime.of(07, 01)) && timeRightNow.isBefore(LocalTime.of(17, 01))){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isWorkHour(){
		LocalTime timeRightNow = LocalTime.now();
		if(timeRightNow.isAfter(LocalTime.of(07, 01)) && timeRightNow.isBefore(LocalTime.of(17, 01))){
			return true;
		}else{
			return false;
		}
	}

	public boolean guestValidTerm(Calendar expirationDate){
		Calendar today = new GregorianCalendar();
		if(today.getTime().before(expirationDate.getTime())){
			return true;
		}else{
			return false;
		}
	}
}
