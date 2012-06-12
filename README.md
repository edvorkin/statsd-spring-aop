statsd-spring-aop
=================

Example of how to add spring AOP around advice to measure performance of application.

Why aspects?
Performance measurement or logging, for example, are a cross-cutting concerns, in that many methods in an application can be measured. 
Aspects offer an alternative to inheritance and delegation that can be cleaner in many circumstances. With AOP, you still define the common functionality in one place, but you can declaratively define how and where this functionality is applied without having to modify the class to which you’re applying the new feature. Cross-cutting concerns can now be modularized into special classes called aspects. This has two benefits. 
First, the logic for each concern is now in one place, as opposed to being scattered all over the code base. 
Second, our service modules are now cleaner since they only contain code for their primary concern (or core functionality) and secondary concerns have been moved to aspects.


What is Statsd:
Statsd is a network daemon that runs on the Node.js platform and listens for statistics, like counters and timers, sent over UDP and sends aggregates to one or more pluggable backend services (e.g., Graphite).
