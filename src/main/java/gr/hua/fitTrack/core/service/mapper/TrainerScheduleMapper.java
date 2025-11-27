package gr.hua.fitTrack.core.service.mapper;

import gr.hua.fitTrack.core.model.TrainerProfile;
import gr.hua.fitTrack.core.model.TrainerWeeklyAvailability;
import gr.hua.fitTrack.core.model.Weekday;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//This mapper is used for taking String values (from html forms) and mapping them to localtime values.
@Component
public class TrainerScheduleMapper {

    public static List<TrainerWeeklyAvailability> mapWeeklyAvailability(
            Map<Weekday,String> startTimes,
            Map<Weekday,String> endTimes,
            TrainerProfile profile
    ){
        List<TrainerWeeklyAvailability> weekly = new ArrayList<>();

        for (Weekday day : Weekday.values()) {

            String start = startTimes.get(day);
            String end = endTimes.get(day);

            LocalTime startTime = null;
            LocalTime endTime = null;

            //if contains N/A the localtime stays null
            if (start != null && !start.equals("N/A") && end != null && !end.equals("N/A")) {
                startTime = LocalTime.parse(start);
                endTime = LocalTime.parse(end);
            }

            //Days are added even if times are null for future schedule changes/overrides
            TrainerWeeklyAvailability availability = new TrainerWeeklyAvailability();
            availability.setTrainerProfile(profile);
            availability.setWeekday(day);
            availability.setStartTime(startTime);
            availability.setEndTime(endTime);

            weekly.add(availability);

        }
        return weekly;
    }
}

