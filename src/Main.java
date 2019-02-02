/*-Написать программу, которая будет распечатывать Ваш возраст, соответствующий ему день рождения и день недели.
до текущего момента времени. Формат:
0 ­- 13.02.1989 ­- Mon
1 ­- 13.02.1990 -­ Tue
*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Main {

    public static void main(String[] args) {
        Calendar rightNow = Calendar.getInstance();
        Calendar birthDay = Calendar.getInstance();
        DateFormat birthdayFormat = new SimpleDateFormat("dd.MM.yyy");
        DateFormat dayName = new SimpleDateFormat("E");

        int birthYear=1985;  //My birthday data
        int birthdayDay = 21;
        int birthMonth = Calendar.JULY;

        int i=0;
        birthDay.set(birthYear,birthMonth,birthdayDay);
        while (birthDay.before(rightNow)) {
            System.out.println(i + ": " + birthdayFormat.format(birthDay.getTime()) + " - " + dayName.format(birthDay.getTime()));
            birthYear++;
            i++;
            birthDay.set(birthYear,birthMonth,birthdayDay);
        }
    }
}