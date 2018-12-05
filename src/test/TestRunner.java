package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
   public static void main(String[] args) {
      Result result1 = JUnitCore.runClasses(UnitTests1.class);

      for (Failure failure : result1.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println("1 is " + result1.wasSuccessful());
      
      
      Result result2 = JUnitCore.runClasses(UnitTests2.class);

      for (Failure failure : result2.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println("2 is " + result2.wasSuccessful());
      
      
      Result result3 = JUnitCore.runClasses(UnitTests3.class);

      for (Failure failure : result3.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println("3 is " + result3.wasSuccessful());
      
      
      Result result4 = JUnitCore.runClasses(UnitTests4.class);

      for (Failure failure : result4.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println("4 is " + result4.wasSuccessful());
      
      
      Result result5 = JUnitCore.runClasses(UnitTests5.class);

      for (Failure failure : result5.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println("5 is " + result5.wasSuccessful());
      
      
      Result result6 = JUnitCore.runClasses(UnitTests6.class);

      for (Failure failure : result6.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println("6 is " + result6.wasSuccessful());
   }
}  	