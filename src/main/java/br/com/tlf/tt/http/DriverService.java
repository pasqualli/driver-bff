package br.com.tlf.tt.http;

import br.com.tlf.tt.models.Driver;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "driver-api")
public interface DriverService {
    @GET
    @Path("/drivers/{id}")
    Uni<Driver> getDriversById(@PathParam("id") int driverId);
}
