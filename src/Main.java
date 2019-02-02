/*-Написать программу, которая будет распечатывать Ваш возраст, соответствующий ему день рождения и день недели.
до текущего момента времени. Формат:
0 ­- 13.02.1989 ­- Mon
1 ­- 13.02.1990 -­ Tue
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.text.ParseException;

public class Main {

    private static final DateFormat BIRTHDAY_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    static{
        BIRTHDAY_FORMAT.setLenient(true);
    }

    //Проверка вводимой даты на допустимость (например: 31 февраля)
    private static boolean isValid(String date){
        try {
            return BIRTHDAY_FORMAT.format(BIRTHDAY_FORMAT.parse(date)).equals(date);
        }catch (ParseException ex){
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        Calendar rightNow = Calendar.getInstance();
        Calendar birthDay = Calendar.getInstance();
        DateFormat birthdayFormat = new SimpleDateFormat("dd.MM.yyy");
        DateFormat dayName = new SimpleDateFormat("E", Locale.ENGLISH);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputDate;

        do {
            System.out.println("Введите дату рождения в формате дд.мм.гггг: ");
            inputDate = reader.readLine();
        } while (!isValid(inputDate));

        String [] parsedDate = inputDate.split("\\.");
        int birthdayDay = Integer.parseInt(parsedDate[0]);
        int birthMonth = Integer.parseInt(parsedDate[1])-1; //Месяцы считаются от 0
        int birthYear= Integer.parseInt(parsedDate[2]);
        birthDay.set(birthYear,birthMonth,birthdayDay);

        int i=0;
        while (birthDay.before(rightNow)) {
            System.out.println(i + " - " + birthdayFormat.format(birthDay.getTime()) + " - " + dayName.format(birthDay.getTime()));
            birthYear++;
            i++;
            birthDay.set(birthYear,birthMonth,birthdayDay);
        }
    }
}