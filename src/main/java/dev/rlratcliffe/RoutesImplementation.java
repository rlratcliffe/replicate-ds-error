package dev.rlratcliffe;

import com.datasonnet.document.MediaTypes;
import org.springframework.stereotype.Component;

/**
 * The RoutesImplementation class holds implementations for the end points configured in RoutesGenerated.
 * These routes are based on operation Ids, that correspond to an API end point:  method+path.
 *
 * @author Maven Archetype (camel-openapi-archetype)
 */
@Component
public class RoutesImplementation extends BaseRestRouteBuilder {

    @Override
    public void configure() throws Exception {
        super.configure();
        from(direct("get-hello"))
            .setBody(datasonnet("{opId: 'get-hello'}",
                    String.class,
                    MediaTypes.APPLICATION_JSON.toString(),
                    MediaTypes.APPLICATION_JSON.toString())
            )
        ;
        from(direct("post-greeting"))
            .setBody(datasonnet("{opId: 'post-greeting'}",
                    String.class,
                    MediaTypes.APPLICATION_JSON.toString(),
                    MediaTypes.APPLICATION_JSON.toString())
            )
        ;

    }
}
