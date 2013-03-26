package com.asal.projectmanager.converter;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;

public class DatePropertyEditor extends PropertyEditorSupport {

	protected static Logger logger = Logger.getLogger(DatePropertyEditor.class);
	String[] formats = { "dd/MM/yyyy", "yyyy-MM-dd", "yyyy-MM-dd",
			"MM/dd/yyyy", "MM/dd/yy" };

	Date defaultDate = new Date(0L);

	public void setAsText(String textValue) {
		if (textValue == null) {
			setValue(defaultDate);
			return;
		}
		Date retDate = defaultDate;
		try {
			retDate = DateUtils.parseDate(textValue, formats);
		} catch (ParseException e) {
			logger.error("Cannot parse " + textValue + " as date.", e);
		}
		logger.info(" Set Text Here DDDDDDDDDDDDDDDDDDDDDDDD");
		setValue(retDate);
	}
	
	public String getAsText() {
		Date dateValue =  (Date)getValue();
		SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("dd/MM/yyyy");
		String date_to_string = dateformatyyyyMMdd.format(dateValue);
		//System.out.println("date into dd/MM/yyyy format: " + date_to_string);
		logger.info(" GET Text Here DDDDDDDDDDDDDDDDDDDDDDDD");
		return date_to_string;
	}

}
