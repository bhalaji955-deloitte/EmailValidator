package org.mule.extension.muleconnector.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;
import java.util.regex.*;

import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;


/**
 * This class is a container for operations, every public method in this class will be taken as an extension operation.
 */
public class EmailvalidatorOperations {

  /**
   * Example of an operation that uses the configuration and a connection instance to perform some action.
   */
  @MediaType(value = ANY, strict = false)
  public String retrieveInfo(@Config EmailvalidatorConfiguration configuration, @Connection EmailvalidatorConnection connection){
    return "Using Configuration [" + configuration.getConfigId() + "] with Connection id [" + connection.getId() + "]";
  }

  /**
   * Example of a simple operation that receives a string parameter and returns a new string message that will be set on the payload.
   */
  @MediaType(value = ANY, strict = false)
  public String sayHi(String person) {
    return buildHelloMessage(person);
  }
  @MediaType(value = ANY, strict = false)
  public Boolean emailValidator(String email) {
    return validator(email);
  }

  /**
   * Private Methods are not exposed as operations
   */
  private String buildHelloMessage(String person) {
    return "Hello " + person + "!!!";
  }
   private Boolean validator(String email) {
	   String regex = "^(.+)@(.+)$";
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(email);
       if(matcher.matches()){
           return true;
       }
       else
           return false;
   }
  
}
