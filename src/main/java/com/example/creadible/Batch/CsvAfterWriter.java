package com.example.creadible.Batch;

import com.example.creadible.Model.domain.entity.Model;
import com.example.creadible.Model.domain.repository.ModelRepository;
import com.example.creadible.Model.web.dto.ModelCsvDto;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.*;
@Configuration
@RequiredArgsConstructor
public class CsvAfterWriter implements ItemWriter<ModelCsvDto> {
    private final ModelRepository modelRepository;

    @Override
    public void write(List<? extends ModelCsvDto> list) throws Exception {
        List<Model> modelList = new ArrayList<>();
        list.forEach(csv -> {
            Model model = Model.builder()
                    .age(Integer.parseInt(csv.getAge()))
                    .applicantIncome(Integer.parseInt(csv.getApplicantIncome()))
                    .applicantWorkPeriod(Integer.parseInt(csv.getApplicantWorkPeriod()))
                    .businessType(Integer.parseInt(csv.getBusinessType()))
                    .coapplicantIncome(Float.parseFloat(csv.getCoapplicantIncome()))
                    .creditAmount(Integer.parseInt(csv.getCreditAmount()))
                    .creditHistory(Float.parseFloat(csv.getCreditHistory()))
                    .creditRate(Integer.parseInt(csv.getCreditRate()))
                    .dependents(Integer.parseInt(csv.getDependents()))
                    .education(Integer.parseInt(csv.getEducation()))
                    .gender(Integer.parseInt(csv.getGender()))
                    .isLearned(false)
                    .loanAmount(Integer.parseInt(csv.getLoanAmount()))
                    .loanTerm(Integer.parseInt(csv.getLoanTerm()))
                    .married(Integer.parseInt(csv.getMarried()))
                    .propertyArea(Integer.parseInt(csv.getPropertyArea()))
                    .build();
            modelList.add(model);
        });
        modelRepository.saveAll(modelList);
    }
}
