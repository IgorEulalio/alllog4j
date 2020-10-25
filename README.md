# AllLog4j component to log.

## O que é:
O AllLog4J é um componente que auxilia na formatacão e padronização de logs para apps que utilizam Java.

### Como utilizar:
Para utiliza-lo e bem simples, precisamos executar apenas alguns passos:

1. Importe a dependencia no pom.xml da sua aplicacao:
        `<!--        Logger dependencies-->
        <dependency>
            <groupId>com.fulllog</groupId>
            <artifactId>alllog4j</artifactId>
            <version>0.0.1-1</version>
        </dependency>
        `

2. Crie uma classe LogConfiguration para implementar os @Beans necessarios:
`@Configuration
public class LogConfiguration {
    
    @Bean
    public ServletRegistrationBean dispatcherRegistration() {
        return new ServletRegistrationBean(dispatcherServlet());
    }
    @Bean(name = DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
    public DispatcherServlet dispatcherServlet() {
        return new AllLog4jConfiguration();
    }
    
}`

3. Pronto! Agora você pode ver seu log no seguinte output:
`<{
    "uri": "/users/5eff256dfcf1b206ab063061",
    "clientIp": "0:0:0:0:0:0:0:1",
    "requestHeaders": {
        "authorization": "Bearer igor-eulalio",
        "x-itau-apikey": "129012-1390139-12901",
        "postman-token": "19d8491e-7e45-4209-a268-ec4e5181fae2",
        "host": "localhost:3030",
        "connection": "keep-alive",
        "cache-control": "no-cache",
        "accept-encoding": "gzip, deflate, br",
        "user-agent": "PostmanRuntime/7.26.5",
        "accept": "*/*"
    },
    "method": "GET",
    "integrations": {
        "\"http://localhost:3032/users/\"": [
            {
                "uri": "http://localhost:3032/users/",
                "method": "GET",
                "headers": "[Accept:\"application/json, application/*+json\", Content-Length:\"0\"]",
                "body": ""
            },
            {
                "status": "200 OK",
                "status_text": "",
                "headers": "[Content-Type:\"application/json\", Content-Length:\"2198\", Date:\"Fri, 23 Oct 2020 19:26:03 GMT\", Keep-Alive:\"timeout=60\", Connection:\"keep-alive\"]",
                "body": "[{\"id\":\"5eff256dfcf1b206ab063061\",\"hobbies\":[{\"id\":null,\"category\":\"esportes\",\"sub_category\":\"basquete\"}],\"first_name\":\"Igor\",\"last_name\":\"Eulalio\",\"email\":\"igoreulalio.ie@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}},{\"id\":\"5eff28d32db36b7bbad7cf03\",\"hobbies\":null,\"first_name\":\"Leticia\",\"last_name\":\"Felix\",\"email\":\"lefelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}},{\"id\":\"5eff2e121f69523931d5742e\",\"hobbies\":null,\"first_name\":\"Larissa\",\"last_name\":\"felix\",\"email\":\"larissafelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}},{\"id\":\"5f6a9ea35dee967f550e5bfb\",\"hobbies\":[{\"id\":null,\"category\":\"esportes\",\"sub_category\":\"basquete\"},{\"id\":null,\"category\":\"esportes\",\"sub_category\":\"judo\"}],\"first_name\":\"Lucca\",\"last_name\":\"diego\",\"email\":\"larissafelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":4.8925,\"avaliacoes\":4,\"nota\":[5.0,4.89,4.81,4.87]}},{\"id\":\"5f6d10d3e122da0262cd21f1\",\"hobbies\":null,\"first_name\":null,\"last_name\":\"diego\",\"email\":\"larissafelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}},{\"id\":\"5f6d10efe122da0262cd21f2\",\"hobbies\":null,\"first_name\":\"Lucca\",\"last_name\":\"Higor\",\"email\":\"larissafelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}},{\"id\":\"5f6d10f4e122da0262cd21f3\",\"hobbies\":null,\"first_name\":\"Lucca\",\"last_name\":\"Higor\",\"email\":\"larissafelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}},{\"id\":\"5f6d1142ddfec74b117cde14\",\"hobbies\":null,\"first_name\":\"Lucca\",\"last_name\":\"Higor\",\"email\":\"larissafelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}},{\"id\":\"5f6d118320c4bb5d59070a7c\",\"hobbies\":null,\"first_name\":\"Lucca\",\"last_name\":\"Higor\",\"email\":\"larissafelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}},{\"id\":\"5f6d132174fd4b6e53763ef2\",\"hobbies\":null,\"first_name\":\"Lucca\",\"last_name\":\"Higor\",\"email\":\"larissafelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}},{\"id\":\"5f6d133474fd4b6e53763ef3\",\"hobbies\":null,\"first_name\":\"Lucca\",\"last_name\":\"Higor\",\"email\":\"larissafelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}}]\n"
            }
        ],
        "\"http://localhost:3031/users/\"": [
            {
                "uri": "http://localhost:3031/users/",
                "method": "GET",
                "headers": "[Accept:\"application/json, application/*+json\", Content-Length:\"0\"]",
                "body": ""
            },
            {
                "status": "200 OK",
                "status_text": "",
                "headers": "[Content-Type:\"application/json\", Content-Length:\"2198\", Date:\"Fri, 23 Oct 2020 19:26:02 GMT\", Keep-Alive:\"timeout=60\", Connection:\"keep-alive\"]",
                "body": "[{\"id\":\"5eff256dfcf1b206ab063061\",\"hobbies\":[{\"id\":null,\"category\":\"esportes\",\"sub_category\":\"basquete\"}],\"first_name\":\"Igor\",\"last_name\":\"Eulalio\",\"email\":\"igoreulalio.ie@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}},{\"id\":\"5eff28d32db36b7bbad7cf03\",\"hobbies\":null,\"first_name\":\"Leticia\",\"last_name\":\"Felix\",\"email\":\"lefelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}},{\"id\":\"5eff2e121f69523931d5742e\",\"hobbies\":null,\"first_name\":\"Larissa\",\"last_name\":\"felix\",\"email\":\"larissafelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}},{\"id\":\"5f6a9ea35dee967f550e5bfb\",\"hobbies\":[{\"id\":null,\"category\":\"esportes\",\"sub_category\":\"basquete\"},{\"id\":null,\"category\":\"esportes\",\"sub_category\":\"judo\"}],\"first_name\":\"Lucca\",\"last_name\":\"diego\",\"email\":\"larissafelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":4.8925,\"avaliacoes\":4,\"nota\":[5.0,4.89,4.81,4.87]}},{\"id\":\"5f6d10d3e122da0262cd21f1\",\"hobbies\":null,\"first_name\":null,\"last_name\":\"diego\",\"email\":\"larissafelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}},{\"id\":\"5f6d10efe122da0262cd21f2\",\"hobbies\":null,\"first_name\":\"Lucca\",\"last_name\":\"Higor\",\"email\":\"larissafelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}},{\"id\":\"5f6d10f4e122da0262cd21f3\",\"hobbies\":null,\"first_name\":\"Lucca\",\"last_name\":\"Higor\",\"email\":\"larissafelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}},{\"id\":\"5f6d1142ddfec74b117cde14\",\"hobbies\":null,\"first_name\":\"Lucca\",\"last_name\":\"Higor\",\"email\":\"larissafelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}},{\"id\":\"5f6d118320c4bb5d59070a7c\",\"hobbies\":null,\"first_name\":\"Lucca\",\"last_name\":\"Higor\",\"email\":\"larissafelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}},{\"id\":\"5f6d132174fd4b6e53763ef2\",\"hobbies\":null,\"first_name\":\"Lucca\",\"last_name\":\"Higor\",\"email\":\"larissafelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}},{\"id\":\"5f6d133474fd4b6e53763ef3\",\"hobbies\":null,\"first_name\":\"Lucca\",\"last_name\":\"Higor\",\"email\":\"larissafelix.lf@gmail.com\",\"feedback\":{\"mediaNota\":5.0,\"avaliacoes\":1,\"nota\":[5.0]}}]\n"
            }
        ]
    },
    "request": {},
    "status": 200,
    "response": {
        "id": "5eff256dfcf1b206ab063061",
        "hobbies": [
            {
                "id": null,
                "category": "esportes",
                "sub_category": "basquete"
            }
        ],
        "first_name": "Igor",
        "last_name": "Eulalio",
        "email": "igoreulalio.ie@gmail.com",
        "feedback": {
            "mediaNota": 5.0,
            "avaliacoes": 1,
            "nota": [
                5.0
            ]
        }
    },
    "responseHeaders": {
        "Keep-Alive": "timeout=60",
        "Connection": "keep-alive",
        "Content-Length": "239",
        "Date": "Fri, 23 Oct 2020 19:26:04 GMT",
        "Content-Type": "application/json"
    }
}>`

4. Ofuscando headers:
A biblioteca AllLog4j também oferece ofuscacao de alguns headers que podem conter dados sensiveis, para isso, basta adicionar a seguinte configuracao dentro do application.propperties:
`<fulllog.alllog4j.ofuscate-headers=postman-token, authorization, x-itau-apikey>`
