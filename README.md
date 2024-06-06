# replicate-ds-error

This project replicates an error with 'Datasonnet expression not initialized' in a project with a large amount of DataSonnet files.

## To replicate error:
1. Clone this project and cd to it.
2. Stop running all currently running Java applications.
3. Run application in debug mode with VM arguments where max heap is very small: `-Xmx70m`
4. Put breakpoint on `org.apache.camel.language.datasonnet.DatasonnetExpression` class, line 137.
5. Execute `./curl.sh` to call the GET endpoint a bunch of times
6. Take note of size of the `language.mapperCache.size()` at the breakpoint above: 103 items. Remove the breakpoint, let the program resume.
7. Note the eventual error of 'Datasonnet expression not initialized'.
   Depending on your environment it may take a while to replicate items being removed from the map. Can manually run `language.mapperCache.clear()` to simulate the map being empty and its inability to recover. OR follow these steps to replicate memory load:
   1. Run the curl script a few times
   2. Start another Java application at the same time
   3. Use k6 or a similar tool to replicate load. A k6 script is attached and can be run with `k6 run k6-spike.js`
8. Repeat step 4 and call the API with `curl localhost:9000/api/hello` and note the reduction in the size of the mapperCache.