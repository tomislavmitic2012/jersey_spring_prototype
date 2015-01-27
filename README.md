# jersey_spring_prototype
A prototype with implementation notes about how the system works

In order to run you can type the following at the prompt:
mvn clean jetty:run

To run the tests use:
mvn clean install verify

I am having a problem getting the integration tests to run because the fail safe plugin is not
bootstrapping jetty during the pre-test phase. Further reasearch needs to be done as to why
or we would need to look into programmatically bootstraping jetty within the integration tests.
