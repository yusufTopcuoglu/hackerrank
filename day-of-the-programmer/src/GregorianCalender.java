class GregorianCalender extends Calender {

	GregorianCalender(int year) {
		super(year);
	}

	@Override
	boolean isLeapYear() {
		if (year % 400 == 0) {
			return true;
		}

		if (year % 100 == 0)
			return false;

		return year % 4 == 0;
	}
}
