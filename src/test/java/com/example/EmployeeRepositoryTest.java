package com.example;
import com.example.TestUtil.InMemoryEmployeeRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class EmployeeRepositoryTest {

    InMemoryEmployeeRepo inMemoryEmployeeRepo = new InMemoryEmployeeRepo();

    @Test
    @DisplayName("Saved User Should Be Saved")
    void savedEmployeeShouldBeSaved(){
        inMemoryEmployeeRepo.save(new Employee("1",  20000));
        assertThat(List.copyOf(inMemoryEmployeeRepo.findAll()).size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Multiple Saved Users With Different Ids Should Be Saved")
    void multipleSavedUsersWithDifferentIdsShouldBeSaved(){
        inMemoryEmployeeRepo.save(new Employee("1",  20000));
        inMemoryEmployeeRepo.save(new Employee("2",  30000));
        assertThat(List.copyOf(inMemoryEmployeeRepo.findAll()).size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Saved Employee That Has Same ID As Another Saved Employee Should Replace The Old Employee")
    void savedEmployeeThatHasSameIdAsAnotherSavedEmployeeShouldReplacedTheOldEmployee(){
        inMemoryEmployeeRepo.save(new Employee("1",  20000));
        inMemoryEmployeeRepo.save(new Employee("1", 30000));
        Employee employee = inMemoryEmployeeRepo.findAll().get(0);
        assertThat(employee.getSalary()).isEqualTo(30000);
    }

    @Test
    @DisplayName("Initial List Should Be Empty")
    void initialListShouldBeEmpty(){
        List<Employee> shouldBeEmpty = inMemoryEmployeeRepo.findAll();
        assertThat(shouldBeEmpty.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("Initial List Should Not Be Null")
    void initialListShouldNotBeNull(){
        List<Employee> shouldBeEmpty = inMemoryEmployeeRepo.findAll();
        assertThat(shouldBeEmpty).isNotNull();
    }
}