package io.freevariable.autocentral.repository;


import io.freevariable.autocentral.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
