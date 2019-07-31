package org.springframework.transaction;

import org.springframework.tests.sample.beans.TestBean;
import org.springframework.transaction.annotation.Transactional;

public class AmazarashiTestBean2 extends TestBean  {

    @Override
    @Transactional // <2>
    public Object returnsThis() {
        return super.returnsThis();
    }

	@Override
	public String toString() {
		return "amazarashiTestBean2";
	}

}