package com.example.soccerapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.example.soccerapp.service.TeamService;

@Configuration
@EnableScheduling
public class SchedulingConfig {

    @Autowired
    private TeamService teamService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void updateTeamRankings() {
    }
}
