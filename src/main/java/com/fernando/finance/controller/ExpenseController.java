package com.fernando.finance.controller;

import com.fernando.finance.model.dto.expense.ExpenseRequestDto;
import com.fernando.finance.model.dto.expense.ExpenseResponseDto;
import com.fernando.finance.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
@CrossOrigin
@AllArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping
    private ResponseEntity<List<ExpenseResponseDto>> get() {
        return new ResponseEntity<>(expenseService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<ExpenseResponseDto> save(@RequestBody ExpenseRequestDto expenseRequestDto) {
        return new ResponseEntity<>(expenseService.save(expenseRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<ExpenseResponseDto> update(@PathVariable int id, @RequestBody ExpenseRequestDto expenseRequestDto){
        return new ResponseEntity<>(expenseService.update(id, expenseRequestDto), HttpStatus.OK);
    }
}
