package pmoreira.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jettison.JettisonFeature;

import pmoreira.model.Cerveja;
import pmoreira.model.rest.Cervejas;

public class Cliente {

    private static final Client CLIENT = ClientBuilder.newClient();

    public Cervejas getCervejas() {
        return CLIENT.register(JettisonFeature.class).target(Constants.HOST).path("cervejas").request("application/xml").get(Cervejas.class);
    }

    public Cerveja criarCerveja(Cerveja cerveja) {
        return CLIENT.target(Constants.HOST).path("cervejas").request().post(Entity.xml(cerveja), Cerveja.class);
    }

    public Response criarCerveja2(Cerveja cerveja) {
        return CLIENT.target(Constants.HOST).path("cervejas").request().post(Entity.xml(cerveja));
    }
}