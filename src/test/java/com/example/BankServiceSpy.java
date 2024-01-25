package com.example;

public class BankServiceSpy implements BankService{
    public boolean payWasCalled = false;
    @Override
    public void pay(String id, double amount) {
        payWasCalled = true;
    }
}
