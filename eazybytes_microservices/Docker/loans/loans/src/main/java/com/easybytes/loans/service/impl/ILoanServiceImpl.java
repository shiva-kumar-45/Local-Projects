package com.easybytes.loans.service.impl;

import com.easybytes.loans.dto.LoansDTO;
import com.easybytes.loans.entity.Loans;
import com.easybytes.loans.exception.LoanAlreadyExistsException;
import com.easybytes.loans.exception.ResourceNotFoundException;
import com.easybytes.loans.mapper.LoansMapper;
import com.easybytes.loans.repository.LoansRepository;
import com.easybytes.loans.service.ILoanService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class ILoanServiceImpl implements ILoanService {

    @Autowired
    private LoansRepository loansRepository;


    @Override
    public String createLoan(String mobileNumber) {

        Optional<Loans> loans = loansRepository.findByMobileNumber(mobileNumber);
        if(loans.isPresent()){
           throw new LoanAlreadyExistsException("Loan already registered with given mobileNumber "+mobileNumber);
        }
        Loans loan = createNewLoan(mobileNumber);
        loansRepository.save(loan);
        return "loan Created";
    }



    private Loans createNewLoan(String mobileNumber) {
        Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType("HOME_LOAN");
        newLoan.setTotalLoan(100000);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(100000);
        return newLoan;
    }

    @Override
    public LoansDTO fetchLoan(String mobileNumber) {
        Optional<Loans> loans = loansRepository.findByMobileNumber(mobileNumber);
        if(loans.isPresent()){
            return LoansMapper.mapToLoansDTO(loans.get(), new LoansDTO());
        }
        else{
            throw new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber);
        }

    }

    @Override
    public boolean updateLoan(LoansDTO loansDto) {

        Optional<Loans> loans = loansRepository.findByLoanNumber(loansDto.getLoanNumber());
        if(loans.isPresent()){
            LoansMapper.mapToLoans(loansDto, loans.get());
            loansRepository.save(loans.get());
        }
        else{
            throw new ResourceNotFoundException("Loan", "loanNumber", loansDto.getLoanNumber());
        }

        return true;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {

        Optional<Loans> loans = loansRepository.findByMobileNumber(mobileNumber);
        if(loans.isPresent()){
            loansRepository.deleteById(loans.get().getLoanId());
        }
        else{
            throw new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber);
        }
        return true;
    }
}
