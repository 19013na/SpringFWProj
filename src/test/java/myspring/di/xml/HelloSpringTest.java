package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

//SpringExtension 클래스는 ApplicationContext(컨테이너)객체를 생성하는 역할을 함
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:hello-di.xml")
public class HelloSpringTest {
	@Autowired
	Hello hello;
	
	// hello-di.xml bean id와 이름을 같게 해줘야 한다.
	@Autowired
	Printer strPrinter;
	
	// 에러 발생 -> 선언하는 것만으로 선언한 변수 이름과 같은 bean id를 찾는다
	// -> @Qualifier
	@Autowired
	@Qualifier("strPrinter")
	Printer printer;
	
	@Resource(name = "hello")
	Hello helloBean;
	
	@Test
	void helloSpringBean() {
		assertEquals("Hello 스프링", hello.sayHello());
		hello.print();
		assertEquals("Hello 스프링", strPrinter.toString());
		System.out.println(strPrinter.getClass().getName());
		
		assertEquals("Hello 스프링", printer.toString());
		
		assertEquals("Hello 스프링", helloBean.sayHello());
	}
}