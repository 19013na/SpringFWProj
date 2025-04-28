package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.annotation.Resource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// bean이랑 container랑 연결 어노테이션
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
	
	//@Resource(name = "shoppingCart")
	@Autowired
	ShoppingCart cart;
	
	//@Resource(name = "orderService")
	@Autowired
	OrderService service;
	
	@Test @Disabled
	void testShoppingCart() {
		assertNotNull(cart);
		assertEquals(2, cart.getProducts().size());
		// 총 가격 확인
		assertEquals(6000.0, cart.getTotalPrice(), 0.001);
		assertEquals("당근", cart.getProducts().get(0).getName());;
	}
	
	@Test
	void testOrder() {
		assertNotNull(cart);
		assertNotNull(service.getShoppingCart());
		assertEquals(6000.0, service.calculateOrderTotal(), 0.001);
		String cartName = service.getShoppingCart().getProducts().get(0).getName();
		assertEquals("당근", cartName);
		// Product		
		for(Product product : service.getShoppingCart().getProducts()) {
			System.out.println(product);
		}
	}
}
