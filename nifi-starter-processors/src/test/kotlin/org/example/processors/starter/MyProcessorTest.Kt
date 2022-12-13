package org.example.processors.starter;

import org.apache.nifi.util.TestRunner;
import org.apache.nifi.util.TestRunners;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyProcessorTest {

  private TestRunner testRunner;

  @BeforeEach
  public void init() {
    testRunner = TestRunners.newTestRunner(MyProcessor.class);
  }

  @Test
  public void testProcessor() {}
}
