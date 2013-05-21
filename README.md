# PlainJSR - Plain JavaScript and REST

## Why?
After years of web development and the apperance of HTML5 I believe that web client programming is now as simple as desktop client programming.
There is no longer a need for server side frameworks like JSF, PHP etc.

After some discussions I was pointed to ROCA style: http://roca-style.org.
I agree with ROCA expect that JHCR makes heavy use of JavaScript or in other words PlainJSR without JavaScript does not work!

I adapted most of the ROCA principles and created JHCR. 
PlainJSR makes use of plain JavaScript, HTML, CSS and REST services. 

The REST services can be implemented in any technology. The examples uses Java EE 6.

The example does not use any JavaScript framework, to show that it is quite simple to use plain JavaScript. But PlainJSR does not forbid the usage of any if they really help frameworks.

## Examples
### emp_gae
Runs on Google App Engine: https://jhcremp.appspot.com/

### emp_javaee
This example is developed using NetBeans and runs on GlassFish 3.1.x.

Note: You have to a datasource named 'jdbc/emp'.
