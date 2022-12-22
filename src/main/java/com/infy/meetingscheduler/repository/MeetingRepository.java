package com.infy.meetingscheduler.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.infy.meetingscheduler.entity.Meeting;

public interface MeetingRepository extends  CrudRepository<Meeting,Integer>{
	

	/*
	@Query("SELECT * FROM meeting m WHERE m.scheduler_name=:schedulerName")
	List <Meeting> findBySchedulerName(@Param("schedulerName") String schedulerName);
	
	 @Query("SELECT * FROM meeting m WHERE m.scheduler_name=:schedulerName AND m.meeting_date=:meetingDate")
	List <Meeting> findBySchedulerNameAndMeetingDate(@Param("schedulerName") String schedulerName, @Param("meetingDate") LocalDate meetingDate);
	
  @Query("SELECT * FROM meeting m WHERE m.team_name=:teamName AND m.meeting_date=:meetingDate")
	List <Meeting> getByTeamNameAndMeetingDate(@Param("teamName") String teamName,@Param("meetingDate") LocalDate meetingDate);
*/
	
	// @Query("SELECT * FROM meeting m WHERE m.scheduler_name=:schedulerName")
	List <Meeting> findBySchedulerName( String schedulerName);
	// @Query("SELECT * FROM meeting m WHERE m.scheduler_name=:schedulerName AND m.meeting_date=:meetingDate")
	List <Meeting> findBySchedulerNameAndMeetingDate(String schedulerName, LocalDate meetingDate);
	 
//	 @Query("SELECT * FROM meeting m WHERE m.team_name=:teamName AND m.meeting_date=:meetingDate")
	List <Meeting> findByTeamNameAndMeetingDate(String teamName, LocalDate meetingDate);

	
/*
@Query("SELECT * FROM meeting m WHERE m.scheduler_name=:schedulerName")
List <Meeting> findBySchedulerName(@Param("schedulerName") String schedulerName);

@Query("SELECT * FROM meeting m WHERE m.scheduler_name=:schedulerName AND m.meeting_date=:meetingDate")
List <Meeting> findBySchedulerNameAndMeetingDate(@Param("schedulerName") String schedulerName, @Param("meetingDate") LocalDate meetingDate);

@Query("SELECT * FROM meeting m WHERE m.team_name=:teamName AND m.meeting_date=:meetingDate")
List <Meeting> getByTeamNameAndMeetingDate(@Param("teamName") String teamName,@Param("meetingDate") LocalDate meetingDate);
	*/
}