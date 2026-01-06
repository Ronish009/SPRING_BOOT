package com.ron.inetpsa.config;

import com.ron.inetpsa.entity.Person;
import com.ron.inetpsa.repository.PersonRepository;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.batch.infrastructure.item.data.RepositoryItemWriter;
import org.springframework.batch.infrastructure.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.LineMapper;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.infrastructure.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.infrastructure.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.infrastructure.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
public class SpringBatchConfig {

    @Autowired
    private PersonRepository personRepository;

    @Bean
    public Job job(JobRepository jobRepository, Step step) {
        return new JobBuilder("importPersons", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Step step(JobRepository jobRepository,
                     PlatformTransactionManager transactionManager,
                     ItemReader<Person> reader,
                     ItemProcessor<Person, Person> processor,
                     ItemWriter<Person> writer) {

        return new StepBuilder("csv-import-step", jobRepository)
                .<Person, Person>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
    @Bean
    public FlatFileItemReader<Person> reader() {
        return new FlatFileItemReaderBuilder<Person>()
                .name("personItemReader")
                .resource(new ClassPathResource("people-1000.csv"))
                .linesToSkip(1)
                .lineMapper(lineMapper())
                .targetType(Person.class)
                .build();
    }

        private LineMapper<Person> lineMapper() {
            DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();

            DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
            lineTokenizer.setDelimiter(",");
            lineTokenizer.setStrict(false);
            lineTokenizer.setNames("id", "userId", "firstName", "lastName", "gender", "email", "phone", "dateOfBirth", "jobTitle");

            BeanWrapperFieldSetMapper<Person> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
            fieldSetMapper.setTargetType(Person.class);

            lineMapper.setLineTokenizer(lineTokenizer);
            lineMapper.setFieldSetMapper(fieldSetMapper);

            return lineMapper;
        }

        @Bean
        public PersonProcessor processor() {
            return new PersonProcessor();
        }

        @Bean
        RepositoryItemWriter<Person> writer(PersonRepository personRepository) {
         return new RepositoryItemWriterBuilder<Person>()
                 .repository(personRepository)
                 .methodName("save")
                 .build();
        }
}

