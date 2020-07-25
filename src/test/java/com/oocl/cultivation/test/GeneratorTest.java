package com.oocl.cultivation.test;

import com.oocl.cultivation.TicketGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneratorTest {
    @Test
    void should_return_4_when_generate_number() {
        TicketGenerator ticketGenerator = new TicketGenerator();

        String result = ticketGenerator.generate();

        assertEquals(4, result.length());
    }
}
