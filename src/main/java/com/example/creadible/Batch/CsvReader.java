package com.example.creadible.Batch;

import com.example.creadible.Model.web.dto.ModelCsvDto;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.*;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;

@Configuration
@RequiredArgsConstructor
public class CsvReader {
    FlatFileItemReader<ModelCsvDto> flatFileItemReader = new FlatFileItemReader<>();
    // csv파일을 한줄 씩 읽게 하는 객체
    DefaultLineMapper<ModelCsvDto> defaultLineMapper = new DefaultLineMapper<>();
    // csv파일을 mapper에 매핑하기 위해서는 tokenizer 선언 필요
    DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer(",");
    public void Setting(String filePath) {
        /* file read */
        flatFileItemReader.setResource(new ClassPathResource(filePath));
        flatFileItemReader.setLinesToSkip(1); // header line skip
        flatFileItemReader.setEncoding("UTF-8"); // encoding
    }

    @Bean
    public FlatFileItemReader<ModelCsvDto> csvFileItemBeforeReader() throws Exception{
        Setting("/csv/BeforeLearning.csv");

        /* delimitedLineTokenizer : setNames를 통해 각각의 데이터의 이름 설정 */
        delimitedLineTokenizer.setNames("id","gender", "age", "married", "dependents", "education",
        "selfEmployed", "businessType", "applicantIncome", "applicantWorkPeriod", "coapplicantIncome", "creditHistory",
                "creditAmount", "propertyArea", "propertyType", "creditRate", "loanAmount", "loanTerm");
        delimitedLineTokenizer.setStrict(false);
        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);

        /* beanWrapperFieldSetMapper : Tokenizer에서 가지고온 데이터들을 VO로 바인드하는 역할 */
        BeanWrapperFieldSetMapper<ModelCsvDto> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(ModelCsvDto.class);

        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

        /* lineMapper 지정 */
        flatFileItemReader.setLineMapper(defaultLineMapper);

        // itemreader에서 필요한 설정들이 제대로 됬는지 검증하는 함수
        flatFileItemReader.afterPropertiesSet();

        return flatFileItemReader;
    }

    @Bean
    public FlatFileItemReader<ModelCsvDto> csvFileItemAfterReader() {
        Setting("/csv/AfterLearning.csv");

        /* delimitedLineTokenizer : setNames를 통해 각각의 데이터의 이름 설정 */
        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer(",");
        delimitedLineTokenizer.setNames("id","gender", "age", "married", "dependents", "education",
                "selfEmployed", "businessType", "applicantIncome", "applicantWorkPeriod", "coapplicantIncome", "creditHistory",
                "creditAmount", "propertyArea", "propertyType", "creditRate", "loanAmount", "loanTerm");
        delimitedLineTokenizer.setStrict(false);
        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);

        /* beanWrapperFieldSetMapper : Tokenizer에서 가지고온 데이터들을 VO로 바인드하는 역할 */
        BeanWrapperFieldSetMapper<ModelCsvDto> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(ModelCsvDto.class);

        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

        /* lineMapper 지정 */
        flatFileItemReader.setLineMapper(defaultLineMapper);

        return flatFileItemReader;
    }
}
