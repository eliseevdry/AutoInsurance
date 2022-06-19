package org.eliseev.autoinsurance.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
public class AutoInsuranceServiceTest {

    @Autowired
    private AutoInsuranceService service;

    @Test
    public void testService() {
        service.testSave();
        service.testGet();
    }
}