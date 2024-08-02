package com.soccerapp.init;

import com.soccerapp.model.entity.Condition;
import com.soccerapp.model.enums.ConditionName;
import com.soccerapp.repository.ResultRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ResultInit implements CommandLineRunner {
    private final ResultRepository resultRepository;

    public ResultInit(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public void run(String... args) {
        boolean hasResult = resultRepository.count() > 0;

        if (!hasResult) {
            List<Result> results = new ArrayList<>();

            Arrays.stream(ResultsDate.values())
                    .forEach(ResultsDate -> {
                        Result result = new Result();
                        result.setName(ResultsDate);
                    });

            resultRepository.saveAll(results);
        }
    }
}
