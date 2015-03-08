package Implementation;


import interfaces.Permanent;
import abstractClasses.Card;

public class Employee extends Card implements Permanent{


	public Employee(String firstName, String lastName, int pinCode) {
		super(pinCode);
		super.setFirstName(firstName);
		super.setLastName(lastName);
	}

	@Override
	public boolean checkPinCode(int pin) {
		if(super.isSuspended()==false){
			if(workHour() & workDay()){
				return true;
			}else if(pin==super.getPin()){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	@Override
	public void setFirstName(String firstName) {
		super.setFirstName(firstName);;

	}

	@Override
	public String getFirstName() {
		return super.getFirstName();
	}

	@Override
	public void setLastName(String lastName) {
		super.setLastName(lastName);
	}

	@Override
	public String getLastName() {
		return super.getLastName();
	}

	@Override
	public void setFullName(String firstName, String LastName) {
		setFirstName(firstName);
		setLastName(LastName);

	}

	@Override
	public String getFullName() {
		return getFirstName() +" "+ getLastName();
	}

	@Override
	public double calculateCredit(double salary, double credit) {
		return salary*credit;
	}

	@Override
	public double calculateBonus(int seniority, double constant) {
		return seniority*constant;
	}
}