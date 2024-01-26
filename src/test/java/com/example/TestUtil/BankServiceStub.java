package com.example.TestUtil;

import com.example.BankService;

public class BankServiceStub implements BankService {
    @Override
    public void pay(String id, double amount) {
        throw new RuntimeException("Runtime Exception from BankService Stub");
    }
}
