package com.example;

import com.example.TestUtil.BankServiceSpy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class EmployeesTest {


    EmployeeRepository employeeRepositoryMock = mock(EmployeeRepository.class);
    BankServiceSpy bankServiceSpy = new BankServiceSpy();

    Employees employees = new Employees(employeeRepositoryMock, bankServiceSpy);


    void addThreeEmployees() {
        when(employeeRepositoryMock.findAll()).thenReturn(Arrays.asList(
                new Employee("1", 32000),
                new Employee("2", 35000),
                new Employee("3", 30000)
        ));

    }

    @Test
    @DisplayName("payEmployees Should Trigger Pay Method In bankServiceSpy")
    void payEmployeesShouldTriggerPayMethodInBankServiceSpy(){
        addThreeEmployees();
        employees.payEmployees();
        assertThat(bankServiceSpy.payWasCalled).isTrue();
    }

    @Test
    @DisplayName("payEmployees should pay the correct amount of employees")
    void payEmployeesShouldPayTheCorrectAmountOfEmployees(){
        addThreeEmployees();
        int numberOfPayments = employees.payEmployees();
        assertThat(numberOfPayments).isEqualTo(3);
    }

    @Test
    @DisplayName("payEmployees should not pay the incorrect amount of employees")
    void payEmployeesShouldNotPayTheIncorrectAmountOfEmployees(){
        addThreeEmployees();
        int numberOfPayments = employees.payEmployees();
        assertThat(numberOfPayments).isNotEqualTo(5);
    }

    @Test
    @DisplayName("When employees is empty Runtime Exception will be thrown from payEmployees")
    void whenEmployeesIsEmptyRuntimeExceptionWillBeThrownFromPayEmployees(){

    }







}
