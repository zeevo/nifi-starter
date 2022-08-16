package org.example.processors.starter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.nifi.annotation.behavior.ReadsAttribute;
import org.apache.nifi.annotation.behavior.ReadsAttributes;
import org.apache.nifi.annotation.behavior.WritesAttribute;
import org.apache.nifi.annotation.behavior.WritesAttributes;
import org.apache.nifi.annotation.documentation.CapabilityDescription;
import org.apache.nifi.annotation.documentation.SeeAlso;
import org.apache.nifi.annotation.documentation.Tags;
import org.apache.nifi.annotation.lifecycle.OnScheduled;
import org.apache.nifi.components.PropertyDescriptor;
import org.apache.nifi.flowfile.FlowFile;
import org.apache.nifi.processor.AbstractProcessor;
import org.apache.nifi.processor.ProcessContext;
import org.apache.nifi.processor.ProcessSession;
import org.apache.nifi.processor.ProcessorInitializationContext;
import org.apache.nifi.processor.Relationship;
import org.apache.nifi.processor.util.StandardValidators;

@Tags({"example"})
@CapabilityDescription("Provide a description")
@SeeAlso({})
@ReadsAttributes({@ReadsAttribute(attribute = "", description = "")})
@WritesAttributes({@WritesAttribute(attribute = "", description = "")})
public class MyProcessor extends AbstractProcessor {

  public static final PropertyDescriptor MY_PROPERTY =
      new PropertyDescriptor.Builder()
          .name("MY_PROPERTY")
          .displayName("My property")
          .description("Example Property")
          .required(true)
          .addValidator(StandardValidators.NON_EMPTY_VALIDATOR)
          .build();

  public static final Relationship MY_RELATIONSHIP =
      new Relationship.Builder()
          .name("MY_RELATIONSHIP")
          .description("Example relationship")
          .build();

  private List<PropertyDescriptor> descriptors;

  private Set<Relationship> relationships;

  @Override
  protected void init(final ProcessorInitializationContext context) {
    descriptors = new ArrayList<>();
    descriptors.add(MY_PROPERTY);
    descriptors = Collections.unmodifiableList(descriptors);

    relationships = new HashSet<>();
    relationships.add(MY_RELATIONSHIP);
    relationships = Collections.unmodifiableSet(relationships);
  }

  @Override
  public Set<Relationship> getRelationships() {
    return this.relationships;
  }

  @Override
  public final List<PropertyDescriptor> getSupportedPropertyDescriptors() {
    return descriptors;
  }

  @OnScheduled
  public void onScheduled(final ProcessContext context) {}

  @Override
  public void onTrigger(final ProcessContext context, final ProcessSession session) {
    FlowFile flowFile = session.get();
    if (flowFile == null) {
      return;
    }
    // TODO implement
  }
}
