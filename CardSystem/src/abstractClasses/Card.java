package abstractClasses;

import java.util.Calendar;
import java.util.GregorianCalendar;

import helperClasses.TimeHandler;

public abstract class Card implements Cloneable, Comparable<Card>{
	private static int numberOfCards=100;
	private int cardNumber = 0;
	private Calendar dateCreated;
	private int pinCode;
	private boolean cardSuspended;
	private TimeHandler handleTime;
	private String firstName;
	private String lastName;


	public Card(int pinCode){
		handleTime= new TimeHandler();
		dateCreated = new GregorianCalendar();
		this.pinCode=pinCode;
		this.cardSuspended = false;
		this.firstName="";
		this.lastName="";
		numberOfCards++;
		cardNumber = numberOfCards;
	}

	public int getPin(){
		return pinCode;
	}

	public int getCardNumber(){
		return cardNumber;
	}

	public void setCardNumber(int cardNumber){
		this.cardNumber=cardNumber;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName=firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setLastName(String lastName){
		this.lastName=lastName;
	}

	public Calendar getDateCreated(){
		return dateCreated;
	}

	public boolean isSuspended(){
		return cardSuspended;
	}

	public void setSuspended(boolean setSuspended){
		cardSuspended=setSuspended;
	}

	public boolean workDay(){
		return handleTime.isWeekday(dateCreated);
	}

	public boolean workHour(){
		return handleTime.isWorkHour();
	}

	public boolean getValidTermGuest(Calendar expirationDate){
		return handleTime.guestValidTerm(expirationDate);	
	}

	public String toString(){
		String returnString=
				"pin code: "+ pinCode+"\n"+
						"card number: "+cardNumber+
						"is suspended: " +isSuspended();
		return returnString;
	}

	public abstract boolean checkPinCode(int pin);

	@Override
	public int compareTo(Card card) {
		int lastNameCompared = getLastName().compareToIgnoreCase(card.getLastName());
		int firstNameCompared;
		if(lastNameCompared  == 0){
			if((firstNameCompared = getFirstName().compareToIgnoreCase(card.getFirstName()))<0){
				return -1;
			}else if(firstNameCompared>0){
				return 1;
			}
		}else if(lastNameCompared > 0){
			return 1;
		}else if(lastNameCompared < 0){
			return -1;
		}
		return 0;

	}

	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
