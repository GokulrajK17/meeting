package com.infy.meetingscheduler.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.meetingscheduler.dto.MeetingDTO;
import com.infy.meetingscheduler.exception.MeetingSchedulerException;
import com.infy.meetingscheduler.service.MeetingService;
@RestController
@RequestMapping("/api")
@Validated
public class MeetingAPI {
	@Autowired
	private MeetingService meetingService;
	
	@GetMapping("/meetings/{schedulerName}")	 
	public ResponseEntity<List<MeetingDTO>> getAllMeetingOfScheduler(@PathVariable @Pattern(regexp = "([a-zA-Z]+)(\\\\s[a-zA-Z]+)*", message= "{meeting.schedulername.invalid}") String schedulerName) throws MeetingSchedulerException
	{
		List<MeetingDTO> meetingList =meetingService.getAllMeetingOfScheduler(schedulerName);
		return new ResponseEntity<>(meetingList,HttpStatus.OK);
		
	}
	@PostMapping("/meetings")
	public ResponseEntity<MeetingDTO> scheduleMeeting(@RequestBody @Valid MeetingDTO meetingDTO) throws MeetingSchedulerException
	{
		MeetingDTO meetingObject = meetingService.scheduleMeeting(meetingDTO);
	//	meetingService.scheduleMeeting(meetingDTO);
		return new ResponseEntity<>(meetingObject,HttpStatus.CREATED);
		
	}
}
