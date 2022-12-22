package com.infy.meetingscheduler.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.meetingscheduler.dto.MeetingDTO;
import com.infy.meetingscheduler.entity.Meeting;
import com.infy.meetingscheduler.exception.MeetingSchedulerException;
import com.infy.meetingscheduler.repository.MeetingRepository;
import com.infy.meetingscheduler.validator.MeetingValidator;
@Service("meetingService")
@Transactional 
public class MeetingServiceImpl  implements MeetingService{
	
	@Autowired
	private MeetingRepository meetingRepository;

	@Override
	public List<MeetingDTO> getAllMeetingOfScheduler(String schedulerName) throws MeetingSchedulerException {
		// TODO Auto-generated method stub
		List<Meeting> meetingList = meetingRepository.findBySchedulerName(schedulerName); 
		
		if(meetingList.isEmpty())
			throw new MeetingSchedulerException("MeetingService.NO_MEETINGS_FOUND");
		List<MeetingDTO> meetingDTOList = new ArrayList<>();
		meetingList.
		stream().
		forEach(x-> meetingDTOList.add(new MeetingDTO().prepareDTO(x)));
		meetingDTOList.sort((x1,x2)->x1.getMeetingDate().compareTo(x2.getMeetingDate()));
		return meetingDTOList;
		
		
	}

	@Override
	public MeetingDTO scheduleMeeting(MeetingDTO meetingDTO)  throws MeetingSchedulerException{
		// TODO Auto-generated method stub
		MeetingValidator.validateMeeting(meetingDTO);
		List<Meeting> meetingList = meetingRepository.findBySchedulerNameAndMeetingDate(meetingDTO.getSchedulerName(),meetingDTO.getMeetingDate());
		if(Boolean.FALSE.equals(meetingList.isEmpty()))
			throw new MeetingSchedulerException("MeetingService.MEETING_DATE_UNAVAILABLE");
		Integer meetingID = meetingRepository.save(meetingDTO.prepareEntity()).getMeetingId();
		meetingDTO.setMeetingId(meetingID);
		return meetingDTO;
	}

}
