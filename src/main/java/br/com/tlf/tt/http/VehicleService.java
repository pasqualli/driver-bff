package br.com.tlf.tt.http;

import br.com.tlf.tt.models.Vehicle;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(configKey = "vehicle-api")
public interface VehicleService {

    @GET
    @Path("/vehicles")
    Uni<List<Vehicle>> getVehicles();
}
