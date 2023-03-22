package io.freevariable.autocentral.repository;


import io.freevariable.autocentral.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
