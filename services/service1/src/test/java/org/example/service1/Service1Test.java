package org.example.service1;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Service1Test {

    Logger log = LoggerFactory.getLogger(Service1Test.class);

    @Test
    void testOne(){
        log.info("This is service one");
        assertEquals(5, 2+3);
    }
}
