package com.easybytes.loans.service;

import com.easybytes.loans.dto.LoansDTO;

public interface ILoanService {


    public String createLoan(String mobileNumber);

    public LoansDTO fetchLoan(String mobileNumber);

    public boolean updateLoan(LoansDTO loansDto);

    public boolean deleteLoan(String mobileNumber);
}
