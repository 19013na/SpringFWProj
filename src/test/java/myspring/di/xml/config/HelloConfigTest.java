package myspring.di.xml.config;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloConfig.class)
public class HelloConfigTest {
	
	@Autowired
	List<String> namesList;
	
	@Autowired
	Hello hello;

	// HelloCOnfig의 메소드 명 strinPrinter을 사용하기 위해 이름 설정 
	@Resource(name = "stringPrinter")
	Printer printer;
	
	@Test
	void testHelloConfig() {
		assertEquals("Hello 스프링", hello.sayHello());
		hello.print();
		assertEquals("Hello 스프링", printer.toString());
		assertEquals("Java", hello.getNames().get(0));
	}
	
	@Test
	void nameList() {
		for (String name : namesList) {
			System.out.println(name);
		}
		assertNotNull(namesList);
	}
}
