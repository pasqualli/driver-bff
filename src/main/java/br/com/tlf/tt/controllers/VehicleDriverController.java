package br.com.tlf.tt.controllers;

import br.com.tlf.tt.services.VehicleDriversService;
import br.com.tlf.tt.services.helpers.VehicleDriver;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Path("/bff")
public class VehicleDriverController {

    private final VehicleDriversService vehicleDriversService;

    @GET
    @Path("/vehicles")
    public Uni<List<VehicleDriver>> getByVehicles() {
        return vehicleDriversService.getVehicleWithDrivers();
    }
}
