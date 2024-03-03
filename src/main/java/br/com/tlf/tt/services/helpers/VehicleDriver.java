package br.com.tlf.tt.services.helpers;

import br.com.tlf.tt.models.Driver;
import br.com.tlf.tt.models.Vehicle;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDriver {

    public Vehicle vehicle;

    public Driver driver;

    public VehicleDriver(Vehicle vehicle, Driver driver) {
        this.vehicle = vehicle;
        this.driver = driver;
    }
}
