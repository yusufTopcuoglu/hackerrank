class JulianCalender extends Calender {

	JulianCalender(int year) {
		super(year);
	}

	@Override
	boolean isLeapYear() {
		return year % 4 == 0;
	}
}
