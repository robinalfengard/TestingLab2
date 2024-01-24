package com.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class EmployeeTest {
    Employee employee = new Employee("1", 32000);

    @Test
    @DisplayName("getId will return correctId for existing user")
    void getIdWillReturnCorrectIdForExistingUser(){
        assertThat(employee.getId()).isEqualTo("1");
    }

    @Test
    @DisplayName("setId will update id for existing user")
    void setIdWillUpdateIdForExistingUser(){
        employee.setId("2");
        assertThat(employee.getId()).isEqualTo("2");
    }

    @Test
    @DisplayName("getSalary will return correct salary for existing user")
    void getSalaryWillReturnCorrectSalaryForExistingUser(){
        assertThat(employee.getSalary()).isEqualTo(32000);
    }

    @Test
    @DisplayName("setSalary will update salary for existing user")
    void setSalaryWillUpdateSalaryForExistingUser(){
        employee.setSalary(34000);
        assertThat(employee.getSalary()).isEqualTo(34000);
    }

    @Test
    @DisplayName("set isPaid to true will have getPaid return true")
    void setIsPaidToTrueWillHaveGetPaidReturnTrue(){
        employee.setPaid(true);
        assertThat(employee.isPaid()).isEqualTo(true);
    }

    @Test
    @DisplayName("set isPaid to false will have getPaid return false")
    void setIsPaidToFalseWillHaveGetPaidReturnFalse(){
        employee.setPaid(false);
        assertThat(employee.isPaid()).isEqualTo(false);
    }


    @Test
    @DisplayName("toString will return correct printout")
    void toStringWillReturnCorrectPrintout(){
        assertThat(employee.toString()).isEqualTo("Employee [id=1, salary=32000.0]");
    }





}