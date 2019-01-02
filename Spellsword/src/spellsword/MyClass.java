/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spellsword;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Elnic
 */
public class MyClass {
    private Map<String,Integer> map;

  public MyClass() {

    map = new HashMap<>();

    map.put("foo", 1);

    map.put("bar", 3);

  }

  public int getValue(String input, int numRetries) throws Exception {

    try {
        System.out.println("test");
      return map.get(input);
        

    }

    catch (Exception e) {

      if (numRetries > 3) {
          System.out.println("testy");
        throw e;

      }
        System.out.println("testy2");
      return getValue(input, numRetries + 1);

    }

  }

}
