package com.example.workhours.service;

import com.example.workhours.model.Workhours;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class WorkhoursService {

    public List<Workhours> getAllWorkhours() {
        return Arrays.asList(
                new Workhours("John Doe", 8),
                new Workhours("Jane Smith", 6),
                new Workhours("Mike Johnson", 7)
        );
    }
}
