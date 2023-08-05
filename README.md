# Issue on Micrometer-Registry-Prometheus upgrade

This repository contains test code to replicate the issue encountered when upgrading Spring Boot from 2.3.x to 2.7.x on a project containing the micrometer-registry-prometheus dependency.
The latter dependency's version is retrieved from the parent and thus also upgraded from version 1.5.14 to 1.9.13, as stated here:

- [Spring Boot 2.3.x dependency versions](https://docs.spring.io/spring-boot/docs/2.3.x/reference/html/dependency-versions.html)
- [Spring Boot 2.7.x dependency versions](https://docs.spring.io/spring-boot/docs/2.7.x/reference/html/dependency-versions.html)

To replicate, simply download this repository and run both the projects in the 2 different directories.

The first one will run smoothly, while the second should throw the following:

```
java.lang.IllegalArgumentException: Failed to register Collector of type MicrometerCollector: test_metric is already in use by another Collector of type MicrometerCollector
```
