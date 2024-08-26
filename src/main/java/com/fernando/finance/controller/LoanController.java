package com.fernando.finance.controller;

import com.fernando.finance.model.dto.loan.LoanRequestDto;
import com.fernando.finance.model.dto.loan.LoanResponseDto;
import com.fernando.finance.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan")
@CrossOrigin
//@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    private ResponseEntity<List<LoanResponseDto>> get() {
        return new ResponseEntity<>(loanService.get(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<LoanResponseDto> findOne(@PathVariable Integer id) {
        return new ResponseEntity<>(loanService.findOne(id), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<LoanResponseDto> save(@RequestBody LoanRequestDto loanRequestDto) {
        return new ResponseEntity<>(loanService.save(loanRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<LoanResponseDto> update(
            @PathVariable int id,
            @RequestBody LoanRequestDto loanRequestDto
    ) {
        return new ResponseEntity<>(loanService.update(id, loanRequestDto), HttpStatus.OK);
    }
}
