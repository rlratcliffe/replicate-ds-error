# replicate-ds-error

This API project was generated using MS3's [Camel OpenAPI Archetype](https://github.com/MS3Inc/camel-archetypes), version 0.2.8-SNAPSHOT.

This project replicates an error with 'Datasonnet expression not initialized' in a project with a large amount of DataSonnet files. It appears that when there are a large amount of DataSonnet (DS) files added to a project, due to using SimpleSoftCache to store the DS scripts when the project's memory becomes more than the heap, that DataSonnet expressions are removed from the mapper cache, and the application becomes unusable at that point.

## To replicate error:
1. Clone this project and cd to it.
2. Stop running all currently running Java applications.
3. Run application in debug mode with VM arguments `-Xmx70m`
4. Put breakpoint on org.apache.camel.language.datasonnet.DatasonnetExpression class, line 137.
5. Execute `./curl.sh` to call the GET point a bunch of times
6. Take note of size of the `language.mapperCache.size()` at the breakpoint above: 103 items. Remove the breakpoint, let the program resume.
7. Note the eventual error of 'Datasonnet expression not initialized'. Run the script a few times if necessary, or cancel the script if it shows up early.
8. Repeat step 4 and call the API with `curl localhost:9000/api/hello` and note the reduction in the size of the mapperCache.