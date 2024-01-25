package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {

    InMemoryEmployeeRepo inMemoryEmployeeRepo = new InMemoryEmployeeRepo();

    @Test
    @DisplayName("Saved User Should Be Saved")
    void savedEmployeeShouldBeSaved(){
        inMemoryEmployeeRepo.save(new Employee("1",  20000));
        assertThat(inMemoryEmployeeRepo.findAll().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Multiple Saved Users With Different Ids Should Be Saved")
    void multipleSavedUsersWithDifferentIdsShouldBeSaved(){
        inMemoryEmployeeRepo.save(new Employee("1",  20000));
        inMemoryEmployeeRepo.save(new Employee("2",  30000));
        assertThat(inMemoryEmployeeRepo.findAll().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Saved Employee That Has Same ID As Another Saved Employee Should Replace The Old Employee")
    void savedEmployeeThatHasSameIdAsAnotherSavedEmployeeShouldReplacedTheOldEmployee(){
        inMemoryEmployeeRepo.save(new Employee("1",  20000));
        inMemoryEmployeeRepo.save(new Employee("1", 30000));
        assertThat(1).isEqualTo(inMemoryEmployeeRepo.findAll().size());
    }

}