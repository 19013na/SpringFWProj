package myspring.di.xml.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;


@Configuration()
@PropertySource(value = "classpath:values.properties")
public class HelloConfig {
	@Autowired
	private Environment env;

	// bean에 이름을 주면 strPrinter이 stringPrinter 이름 보다 우선임. 
	//@Bean("strPrinter")
	@Bean()
	public Printer stringPrinter() {
		return new StringPrinter();
	}
	
	@Bean
	public Printer consolePrinter() {
		return new ConsolePrinter();
	}
	
	@Bean
	public Hello hello() {
		Hello hello = new Hello();
		// properties에 있는 myName1값 가져오기
		hello.setName(env.getProperty("myName1"));
		hello.setPrinter(stringPrinter());
		hello.setNames(namesList());
		return hello;
	}
	
	@Bean
	public List<String> namesList(){
		String names = env.getProperty("names.list.of.strings");
//		String[] strArray =  names.split(",");
//		return Arrays.asList(strArray);
		return Arrays.asList(names.split(","));
	}
}
