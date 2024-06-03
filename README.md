# replicate-ds-error

This API project was generated using MS3's [Camel OpenAPI Archetype](https://github.com/MS3Inc/camel-archetypes), version 0.2.8-SNAPSHOT.

### Getting Started

**Running on the Command Line**

```
mvn spring-boot:run
```

<!-- 
**Running Locally using IDE**

This project uses Spring profiles, and corresponding replicate-ds-error-<env>.yaml files.

Use the following environment variables: 
   * ```spring.profiles.active=<env>```
   * ```spring.config.name=replicate-ds-error```

**Running on Command Line**

```
mvn spring-boot:run -Dspring-boot.run.profiles=<env> -Dspring-boot.run.arguments="--spring.config.name=replicate-ds-error"
```
-->

### Actuator Endpoints

To access the list of available Actuator endpoints, go to: http://localhost:8080/actuator or `{{url}}/actuator`

The available endpoints are as follows:

* `/health`
* `/metrics`
* `/info`

#### Metrics

List of available metrics can be found here: http://localhost:8080/actuator/metrics/

Add the metric name in `/metrics/<metric name>` to access the metric for that particular topic.

Sample metric: http://localhost:8080/actuator/metrics/jvm.memory.used

```
{
    "name": "jvm.memory.used",
    "description": "The amount of used memory",
    ...
}
```

### Contact

* Name (email)