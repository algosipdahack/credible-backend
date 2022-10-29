package com.example.creadible.Config;

import com.example.creadible.Batch.*;
import com.example.creadible.Model.web.dto.ModelCsvDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.context.annotation.*;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class FileItemReaderJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final CsvReader csvReader;
    private final CsvBeforeWriter csvBeforeWriter;
    private final CsvAfterWriter csvAfterWriter;

    private static final int chunksize = 1000;

    @Bean
    public Job csvFileItemReaderJob() throws Exception {
        return jobBuilderFactory.get("csvFileItemReaderJob")
                .start(csvFileItemBeforeReaderStep())
                .next(csvFileItemAfterReaderStep())
                .build();
    }

    @Bean
    public Step csvFileItemBeforeReaderStep() throws Exception {
        return stepBuilderFactory.get("csvFileItemBeforeReaderStep")
                .<ModelCsvDto,ModelCsvDto>chunk(chunksize)
                .reader(csvReader.csvFileItemBeforeReader())
                .writer(csvBeforeWriter)
                .build();
    }

    @Bean
    public Step csvFileItemAfterReaderStep() {
        return stepBuilderFactory.get("csvFileItemAfterReaderStep")
                .<ModelCsvDto,ModelCsvDto>chunk(chunksize)
                .reader(csvReader.csvFileItemAfterReader())
                .writer(csvAfterWriter)
                .build();
    }
}
