package programmers.level1;

public class YearOf2016 {
    static String solution(int a, int b) {
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int sumDays = 0;

        for(int i = 1; i < a; i++) {
            sumDays += month[i];
        }
        sumDays += (b - 1);

        return days[sumDays % 7];

        /*int[] lastDay = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] mon = new int[13];
        String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        mon[1] = 4;

        for(int i = 2; i < mon.length; i++) {
            for(int j = mon[i - 1]; j <= lastDay[i - 1]; j += 7) {
                mon[i] = j;
            }
            mon[i] = 7 - (lastDay[i - 1] - mon[i]);
        }

        if(b < mon[a])
            return days[7 - (mon[a] - b)];
        return days[(b - mon[a]) % 7];*/
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 1));
    }
}

//Calendar cal = new Calendar.Builder().setCalendarType("iso8601")
//        .setDate(2016, month - 1, day).build();
//return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();

//allDate += (b - 1);
//answer = day[allDate % 7];

//LocalDate date = LocalDate.of(2016, a, b);
//return date.getDayOfWeek().toString().substring(0, 3);