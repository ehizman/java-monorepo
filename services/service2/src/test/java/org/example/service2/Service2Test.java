package org.example.service2;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Service2Test {
    Logger log = LoggerFactory.getLogger(Service2Test.class);

    @Test
    void testOne(){
        log.info("This is service one");
        assertEquals(15, 2+13);
    }
}
