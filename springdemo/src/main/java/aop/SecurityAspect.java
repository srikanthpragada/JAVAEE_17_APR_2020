package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect 
@Order(1)
public class SecurityAspect {

	@Before(value = "within(aop.*)")
	public void beforeAdviceMethod(JoinPoint jp) {
		System.out.println("Security Check  --> " + jp.getSignature());
	}
}
