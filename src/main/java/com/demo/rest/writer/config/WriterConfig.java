package com.demo.rest.writer.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.demo.rest.writer.batch.EmployeeReader;
import com.demo.rest.writer.batch.EmployeeProcessor;
import com.demo.rest.writer.batch.EmployeeWriter;
import com.demo.rest.writer.dto.EmployeeDTO;
import com.demo.rest.writer.model.Employee;

import javax.sql.DataSource;


@Configuration
@EnableBatchProcessing
public class WriterConfig {

	private static final String PROPERTY_REST_API_URL = "rest.api.to.database.job.api.url";

	/*
	 * @Bean RestTemplate restTemplate() { // return new RestTemplate();
	 * RestTemplate restTemplate = new RestTemplate();
	 * MappingJackson2HttpMessageConverter converter = new
	 * MappingJackson2HttpMessageConverter(); converter.setObjectMapper(new
	 * ObjectMapper()); restTemplate.getMessageConverters().add(converter); return
	 * restTemplate; }
	 */

	@Bean
	ItemReader<EmployeeDTO> restStudentReader(Environment environment, RestTemplate restTemplate) {
		return new EmployeeReader(environment.getRequiredProperty(PROPERTY_REST_API_URL), restTemplate);
	}

	@Bean
	ItemProcessor<EmployeeDTO, Employee> restEmployeeProcessor() {
		return new EmployeeProcessor();
	}

	@Bean
	ItemWriter<Employee> restEmpWriter() {
		return new EmployeeWriter();
	}

	
	/*@Bean
	public JdbcBatchItemWriter<Employee> writer(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Employee>()
			.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
			.sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
			.dataSource(dataSource)
			.build();
	}*/
	@Bean
	Step restEmpStep(ItemReader<EmployeeDTO> restEmpReader, ItemProcessor<EmployeeDTO, Employee> restEmpProcessor,
			ItemWriter<Employee> restEmpWriter, StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("restEmpStep").<EmployeeDTO, Employee>chunk(1).reader(restEmpReader)
				.processor(restEmpProcessor).writer(restEmpWriter).build();
	}

	@Bean
	Job restEmpJob(JobBuilderFactory jobBuilderFactory, @Qualifier("restEmpStep") Step restEmpStep) {
		return jobBuilderFactory.get("restEmpJob").incrementer(new RunIdIncrementer()).flow(restEmpStep).end().build();
	}

}
