package com.infy.meetingscheduler.validator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Date;

import com.infy.meetingscheduler.dto.MeetingDTO;
import com.infy.meetingscheduler.exception.MeetingSchedulerException;

public class MeetingValidator {
	
	private MeetingValidator() {
		
	}

	public static void validateMeeting(MeetingDTO meetingDTO) throws MeetingSchedulerException
	{
		/*if(isValidMeetingDate(meetingDTO.getMeetingDate())==false) {  //by own
			throw new MeetingSchedulerException("MeetingValidator.INVALID_MEETINGDATE");   //by own
		}
		
		if(isValidTeamName(meetingDTO.getTeamName())==false) { //by own 
			throw new MeetingSchedulerException("MeetingValidator.INVALID_TEAM_NAME");  //by own
		}
		if(isValidMeetingDate(meetingDTO.getMeetingDate())==false) {  //by own
			throw new MeetingSchedulerException("MeetingValidator.INVALID_MEETINGDATE");   //by own
		} */
		
		if(Boolean.FALSE.equals(isValidTeamName(meetingDTO.getTeamName()))) { //by own 
			throw new MeetingSchedulerException("MeetingValidator.INVALID_TEAM_NAME");  //by own
		}
		if(Boolean.FALSE.equals(isValidMeetingDate(meetingDTO.getMeetingDate()))) { //by own 
			throw new MeetingSchedulerException("MeetingValidator.INVALID_TEAM_NAME");  //by own
		}
		
	}
	
	public static Boolean isValidTeamName(String teamName) // throws MeetingSchedulerException   // in bracket we pass the string // by own
	{
		String regex = "ETAMYS(JAVA||UI||BI||MS||AI)";
		return teamName.matches(regex);
		
	}
	public static Boolean isValidMeetingDate(LocalDate meetingDate) // throws MeetingSchedulerException  // in bracket we pass the localdate // by own
	{
		//Date day =new Date();
		DayOfWeek day =DayOfWeek.of(meetingDate.get(ChronoField.DAY_OF_WEEK));  //by own
		if ((day==DayOfWeek.SATURDAY)|| (day==DayOfWeek.SUNDAY)) { //by own
			return false ;  //by own
			
		}
		return true; //by own */
		
		//return Boolean.FALSE.equals((meetingDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)|| meetingDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)));
				
	}
}
