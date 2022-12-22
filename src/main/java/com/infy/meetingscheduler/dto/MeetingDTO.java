package com.infy.meetingscheduler.dto;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.infy.meetingscheduler.entity.Meeting;

public class MeetingDTO {
	private Integer meetingId;
	
	@NotNull (message ="{meeting.scheduler.absent}") //by own
	@Pattern(regexp ="([a-zA-Z]+)(\\\\s[a-zA-Z]+)*", message = "{meeting.schedulername.invalid") //by own
	private String schedulerName;
	
	@NotNull (message = "{meeting.team.absent}")  //by own	
	private String teamName;
	
	@NotNull (message = "{meeting.purpose.absent}")  //by own	
	private String purpose;
	
	@NotNull (message = "{meeting.date.absent}") //by own
	@FutureOrPresent( message ="{meeting.date.absent}")
	private LocalDate meetingDate;
	
	public Integer getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}
	public String getSchedulerName() {
		return schedulerName;
	}
	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public LocalDate getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(LocalDate meetingDate) {
		this.meetingDate = meetingDate;
	}
	public MeetingDTO prepareDTO(Meeting meeting) {
		MeetingDTO meetingDTO = new MeetingDTO();
		meetingDTO.setMeetingDate(meeting.getMeetingDate());
		meetingDTO.setMeetingId(meeting.getMeetingId());
		meetingDTO.setPurpose(meeting.getPurpose());
		meetingDTO.setSchedulerName(meeting.getSchedulerName());
		meetingDTO.setTeamName(meeting.getTeamName());
		return meetingDTO;
	}
	
	
	public Meeting prepareEntity() {
		// TODO Auto-generated method stub
		Meeting meeting = new Meeting();
		meeting.setMeetingDate(this.getMeetingDate());
		meeting.setPurpose(this.getPurpose());
		meeting.setSchedulerName(this.getSchedulerName());
		meeting.setTeamName(this.getTeamName());
		return meeting;
	}
}
