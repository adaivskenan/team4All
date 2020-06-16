/**
 * 
 */
package com.adaivskenan.test.cp05_aopprogramming;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author adaivskenan
 *
 */

@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages = "com.adaivskenan.test.cp05_aopprogramming")
public class Config {

}
