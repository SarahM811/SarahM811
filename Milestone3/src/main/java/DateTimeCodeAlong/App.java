/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DateTimeCodeAlong;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author sakim
 */
public class App {
    public static void main(String[] args) {
       //today's date
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        
        //print other date
        ld = LocalDate.parse("2015-01-01");
        System.out.println(ld);
        
        ld = LocalDate.parse("02/07/2010", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(ld);
        
        //convert from string and to string
        String isoDate = ld.toString();
        System.out.println(isoDate);
        ld = LocalDate.parse(isoDate);
        System.out.println(ld);
        
        String formatted = ld.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(formatted);
        
        formatted = ld.format(DateTimeFormatter.ofPattern("MM=dd=yyyy+=+="));
        System.out.println(formatted);
        
//        formatted = ld.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
//        System.out.println(formatted);
//      
        //8 days prior to 2.7.2010
        LocalDate past = ld.minusDays(8);
        formatted = past.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(formatted);
        //3months prior to 2.7.2010
        past = ld.minusMonths(3);
        formatted = past.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(formatted);
        
        Period diff = ld.until(past);
        System.out.println(diff);
        System.out.println(diff.getMonths());
        diff = past.until(ld);
        System.out.println(diff.getMonths());
        //date and time in ISO format
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        formatted = ldt.format(DateTimeFormatter.ofPattern("yyy-MM-dd hh:mm:ss"));
        System.out.println(formatted);
        
        Date legacyDate = new Date();
        System.out.println(legacyDate);
        
        GregorianCalendar legacyCalendar = new GregorianCalendar();
        System.out.println(legacyCalendar);
        
        ZonedDateTime zdt = ZonedDateTime.ofInstant(legacyDate.toInstant(), ZoneId.systemDefault());
        ld = zdt.toLocalDate();
        System.out.println(ld);
        
        zdt = legacyCalendar.toZonedDateTime();
        ld = zdt.toLocalDate();
        System.out.println(ld);
    }
}
