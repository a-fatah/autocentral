package io.freevariable.autocentral.repository;

import io.freevariable.autocentral.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
