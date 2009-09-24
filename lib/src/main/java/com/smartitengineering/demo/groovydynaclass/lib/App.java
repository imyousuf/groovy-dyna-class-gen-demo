package com.smartitengineering.demo.groovydynaclass.lib;

import groovy.lang.GroovyClassLoader;

/**
 * Hello world!
 *
 */
public class App {

		public static void main(String[] args)
						throws Exception {
				GroovyClassLoader classLoader = new GroovyClassLoader(Thread.
								currentThread().getContextClassLoader());
				Class clazz =
							classLoader.parseClass(
								"package com.smartitengineering.demo.dyna.embed;\n" +
								"class Product{int getProductId() {return 0}\n" +
								"public String toString() {return \"Embed\"}}");

				System.out.println("Class = " + clazz.getName());
				final Object newInstance = clazz.newInstance();
				System.out.println("toString` = " + newInstance);
		}
}
