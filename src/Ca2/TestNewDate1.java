/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ca2;

import java.time.LocalDate;

public class TestNewDate1 {

    public static void main(String[] argv) {

        String date = "2016-08-16";

		//default, ISO_LOCAL_DATE
        LocalDate localDate = LocalDate.parse(date);

        System.out.println(localDate);

    }

}
