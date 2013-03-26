package com.asal.projectmanager.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Date dateNow = new Date();
		SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("dd/MM/yyyy");
		String date_to_string = dateformatyyyyMMdd.format(dateNow);
		System.out.println("date into dd/MM/yyyy format: " + date_to_string);


		//Read more: http://javarevisited.blogspot.com/2011/09/convert-date-to-string-simpledateformat.html#ixzz2OInoTG4z
		// TODO Auto-generated method stub

	}

}
