class CalenderFactory {

	static Calender createCalender(int year) {

		// not fits the constraints
		if (year < 1700 || year > 2700) {
			throw new IllegalArgumentException();
		}

		if (year < Solution.TRANSITION_YEAR)
			return new JulianCalender(year);

		return new GregorianCalender(year);

	}
}
