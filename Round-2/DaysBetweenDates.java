class DaysBetweenDates {
    // Main method to find the number of days between two dates
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(totalDaysSince1900(date1) - totalDaysSince1900(date2));
    }

    // Helper function: calculates total days from 1900-01-01 to given date
    private int totalDaysSince1900(String date) {
        // Total days passed at the end of each month (non-leap year)
        int[] daysTillMonthEnd = {31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

        // Extract year, month, day from the date string
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));

        int totalDays = 0;

        // Add days for all years from 1900 up to the year before the given date
        for (int i = 1900; i < year; i++) {
            totalDays += isLeapYear(i) ? 366 : 365;
        }

        // Add days for months in the current year
        if (month > 1) {
            totalDays += daysTillMonthEnd[month - 2];
            // Add 1 extra day if current year is leap and date is after Feb
            if (isLeapYear(year) && month > 2) {
                totalDays++;
            }
        }

        // Add remaining days of current month
        totalDays += day;

        return totalDays;
    }

    // Helper function: checks if a year is leap or not
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // For quick testing
    public static void main(String[] args) {
        DaysBetweenDates sol = new DaysBetweenDates();
        System.out.println(sol.daysBetweenDates("2003-09-03", "2025-11-08")); // 1
        System.out.println(sol.daysBetweenDates("2020-01-15", "2019-12-31")); // 15
    }
}
