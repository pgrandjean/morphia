package com.google.code.morphia.mapping.validation.classrules;


import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import com.google.code.morphia.TestBase;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Property;
import com.google.code.morphia.testutil.TestEntity;


/**
 * @author Uwe Schaefer, (us@thomas-daily.de)
 */
public class RegisterAfterUseTest extends TestBase {

  public static class Broken extends TestEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Property("foo")
    @Embedded("bar")
    List l;
  }

  @Test
  @Ignore(value = "not yet implemented")
  public void testRegisterAfterUse() throws Exception {

    // this would have failed: morphia.map(Broken.class);

    final Broken b = new Broken();
    ds.save(b); // imho must not work
    Assert.fail();

    // doe not revalidate due to being used already!
    morphia.map(Broken.class);
    Assert.fail();
  }
}
