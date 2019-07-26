package org.springframework.transaction;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.tests.sample.beans.TestBean;
import org.springframework.transaction.annotation.Transactional;

public class AmazarashiTestBean2 extends TestBean implements ApplicationListener<ApplicationEvent> {

    @Override
    @Transactional // <2>
    public Object returnsThis() {
        return super.returnsThis();
    }

	@Override
	public String toString() {
		return "amazarashiTestBean2";
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(event);
	}
}