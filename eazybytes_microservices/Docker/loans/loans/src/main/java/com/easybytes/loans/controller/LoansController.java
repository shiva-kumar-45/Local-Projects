package com.easybytes.loans.controller;

import com.easybytes.loans.dto.LoansDTO;
import com.easybytes.loans.service.ILoanService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoansController {


    @Autowired
    private ILoanService loanService;

    @PostMapping("/create")
    public String createLoans(@RequestParam String mobileNumber) {
        String response = loanService.createLoan(mobileNumber);
        return response;

    }

    @GetMapping("/fetch")
    public ResponseEntity<LoansDTO> fetchLoanDetails(@RequestParam
                                                     @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                     String mobileNumber) {
        LoansDTO loansDto = loanService.fetchLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loansDto);
    }

    @PutMapping("/update")
    public String updateLoanDetails(@RequestBody LoansDTO loansDto) {
        boolean isUpdated = loanService.updateLoan(loansDto);
        if (isUpdated) {
            return "Loan details updated successfully";
        } else {
            return "Loan details not updated";
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteLoanDetails(@RequestParam String mobileNumber) {
        boolean isDeleted = loanService.deleteLoan(mobileNumber);
        if (isDeleted) {
            return ResponseEntity.ok("Loan details deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
