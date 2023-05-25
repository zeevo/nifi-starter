package org.example.processors.starter

import org.apache.nifi.util.TestRunner;
import org.apache.nifi.util.TestRunners;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyProcessorTest {

    private var testRunner : TestRunner? = null ;

    @BeforeEach
    fun init() {
        testRunner = TestRunners.newTestRunner(MyProcessor::class.java);
    }

    @Test
    fun testProcessor() {}
}
