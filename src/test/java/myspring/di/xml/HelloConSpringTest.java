package myspring.di.xml;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:hello-di.xml")
public class HelloConSpringTest {
	@Autowired
	@Qualifier("helloC")
	Hello hello;

	//@Autowired
	
	@Test
	void helloCons() {
		//System.out.println(hello.sayHello());
		//assertEquals("Hello 생성자", hello.sayHello());
		hello.print();
		
		assertEquals(3, hello.getNames().size());
		assertEquals("스프링부트", hello.getNames().get(1));
		for(String name : hello.getNames()) {
			System.out.println(name);
		}
		// Iterable 인터페이스의 forEach(Consumer) 메서드 호출하기
		// 람다식 함수형 인터페이스
		
		
	}
}
