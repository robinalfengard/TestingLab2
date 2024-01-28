package com.example;

import com.example.TestUtil.BankServiceSpy;
import com.example.TestUtil.BankServiceStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeesTest {


    EmployeeRepository employeeRepositoryMock = mock(EmployeeRepository.class);
    BankServiceSpy bankServiceSpy = new BankServiceSpy();

    BankServiceStub bankServiceStub = new BankServiceStub();

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
    @DisplayName("If Runtime Exception is Thrown Payments Wont Be Completed")
    void IfRuntimeExceptionIsThrownPaymentsWontBeCompleted(){
        Employees employees = new Employees(employeeRepositoryMock, bankServiceStub);
        addThreeEmployees();
        int numberOfPayments = employees.payEmployees();
        assertThat(numberOfPayments).isEqualTo(0);
    }

    @Test
    @DisplayName("If Runtime Exception is Thrown isPaid On Employee Should Be False")
    void IfRuntimeExceptionIsThrownIsPaidOnEmployeeShouldBeFalse(){
        Employees employees = new Employees(employeeRepositoryMock, bankServiceStub);
        addThreeEmployees();
        employees.payEmployees();
        boolean isFirstEmployeePaid = employeeRepositoryMock.findAll().get(0).isPaid();
        assertFalse(isFirstEmployeePaid);
    }







}
