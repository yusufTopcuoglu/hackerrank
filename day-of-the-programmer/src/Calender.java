abstract class Calender {

	int year;

	Calender(int year) {
		this.year = year;
	}

	abstract boolean isLeapYear();

	String getDate() {
		if (isLeapYear())
			return "12.09." + year;
		return "13.09." + year;
	}
}
