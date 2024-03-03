package br.com.tlf.tt.services;

import br.com.tlf.tt.http.DriverService;
import br.com.tlf.tt.http.VehicleService;
import br.com.tlf.tt.models.Vehicle;
import br.com.tlf.tt.services.helpers.VehicleDriver;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class VehicleDriversService {
    @RestClient
    DriverService driverService;

    @RestClient
    VehicleService vehicleService;


    public Uni<List<VehicleDriver>> getVehicleWithDrivers() {
        return vehicleService.getVehicles()
                .onItem()
                .transformToMulti(vehicles -> Multi.createFrom().iterable(vehicles))
                .onItem().transformToUniAndMerge(this::getDriverByVehicle)
                .collect().asList();
    }

    private Uni<VehicleDriver> getDriverByVehicle(Vehicle vehicle) {
        return this.driverService.getDriversById(vehicle.getDriverId())
                .map(driver -> new VehicleDriver(vehicle, driver));
    }
}
