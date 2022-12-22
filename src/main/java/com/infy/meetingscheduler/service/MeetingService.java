 package com.infy.meetingscheduler.service;

import java.util.List;

import com.infy.meetingscheduler.dto.MeetingDTO;
import com.infy.meetingscheduler.exception.MeetingSchedulerException;

public interface MeetingService {
List<MeetingDTO> getAllMeetingOfScheduler(String schedulerName) throws MeetingSchedulerException;
MeetingDTO scheduleMeeting(MeetingDTO meetingDTO) throws MeetingSchedulerException;
}
