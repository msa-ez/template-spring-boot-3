### Java 17 has become the standard.
#### Java 17, the latest Long Term Support (LTS) version, includes new features such as records, instanceOf, and multiline strings. Starting with Spring Boot 3.0, it is designed to operate with Java 17 and above. Therefore, migrating from earlier Spring Boot versions requires an update to Java 17. Maybe now is a good time to consider updating to Java 17?

### Support for Jakarta EE is introduced.
#### If you're migrating from previous Spring Boot versions, an essential change to note is the namespace transition from javax.* to jakarta.*. This change was instigated due to Java trademark issues. Most Java developers might have heard of Java EE. It stands for Enterprise Edition, a standard introduced by Sun Microsystems for distributed application development. Common examples include Servlet, JSP, JDBC, JMX, etc. For instance, by using a JDBC driver that meets the Java EE compatibility spec, developers can effortlessly switch to a different Database like MySQL, Oracle, or PostgreSQL.

#### However, post the Sun-Oracle merger, the commercial platform of Java EE couldn't keep up with the rapid technological trends and was eventually transferred to the non-profit Eclipse Foundation in 2017. In 2019, Jakarta EE 8, fully compatible with Java EE 8, was released. Thus, the Java EE platform transitioned to a vendor-neutral, community-driven process. The renaming to "jakarta" was necessary due to Oracle owning the Java trademark. This led to the namespace transition from javax to jakarta in Jakarta EE 9, released in 2020.

#### By the way, "jakarta" is named after the largest city on Java Island and the capital of Indonesia.

### Official support for Observability.
#### There's the new Micrometer Observation API and the previously independent Spring Cloud Sleuth project has migrated to Micrometer Tracing. This initiative provides functionality to efficiently record application metrics with Micrometer and implement tracing through providers like OpenZipkin or OpenTelemetry.

### Official support for Spring Native based on GraalVM, after three years of experimentation.
#### As systems have become more sophisticated and especially with the adoption of microservice architectures across many organizations, resource demands have increased. Combining Java with Spring Boot can lead to longer server startup times and inherently higher memory usage. GraalVM emerged as a solution to these issues. By using it, even Java projects can be compiled to native binaries, significantly reducing startup time and memory consumption. Spring Native leverages the GraalVM Native Image compiler, enabling easy creation of native binaries suitable for cloud environments.
