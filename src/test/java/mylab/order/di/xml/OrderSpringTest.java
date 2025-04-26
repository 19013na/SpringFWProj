package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.annotation.Resource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
	
	@Resource(name = "shoppingCart")
	ShoppingCart cart;
	
	@Resource(name = "orderService")
	OrderService service;
	
	@Test @Disabled
	void testShoppingCart() {
		assertNotNull(cart);
		// 총 가격 확인
		assertEquals(6000.0, cart.getTotalPrice(), 0.001);
	}
	
	@Test
	void testOrder() {
		assertNotNull(cart);
		assertEquals(6000.0, service.calculateOrderTotal(), 0.001);
		String cartName = service.getShoppingCart().getProducts().get(0).getName();
		assertEquals("당근", cartName);
		// Product		
		for(Product product : service.getShoppingCart().getProducts()) {
			System.out.println(product);
		}
	}
}
