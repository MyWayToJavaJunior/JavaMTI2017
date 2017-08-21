package ru.mti.edu.customtag;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class CurrentDay extends BodyTagSupport {

	private int year;
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().println(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
			
			pageContext.getOut().println("atribute value : " + year);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_TAG;
	}
}
