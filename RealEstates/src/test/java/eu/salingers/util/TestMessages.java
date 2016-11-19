package eu.salingers.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.junit.Test;

import data.Messages;
public class TestMessages {
  
  
  
  
  @Test
  public void accessPrivateConstructorViaReflection_throwsAccessError() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Constructor<Messages> constructor = Messages.class.getDeclaredConstructor();
    assertTrue(Modifier.isPrivate(constructor.getModifiers()));  
    constructor.setAccessible(Boolean.TRUE);
    constructor.newInstance();
  }
  
  
  
  @Test
  public void getString_inexistingKey_() {
    String m = Messages.getString("NotExistingKey");
    assertThat(m, equalTo('!' + "NotExistingKey" + '!'));
    System.out.println("String: " + m);
  }

}
