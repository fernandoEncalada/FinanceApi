package com.fernando.finance.service.implementation;

import com.fernando.finance.model.StatusType;
import com.fernando.finance.model.dbmo.Loan;
import com.fernando.finance.model.dto.loan.LoanRequestDto;
import com.fernando.finance.model.dto.loan.LoanResponseDto;
import com.fernando.finance.model.repository.LoanRepository;
import com.fernando.finance.model.repository.PersonRepository;
import com.fernando.finance.service.LoanService;
import com.fernando.finance.utils.DateMethods;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final PersonRepository personRepository;

    @Override
    public List<LoanResponseDto> get() {
        return loanRepository.findAll().stream().map(this::mapToDto).toList();
    }

    @Override
    public LoanResponseDto save(LoanRequestDto loanRequestDto) {
        Loan loan = new Loan();
        loan.setDescription(loanRequestDto.getDescription());
        loan.setAmount(loanRequestDto.getAmount());
        loan.setStatus(loanRequestDto.getStatus() == 0 ? StatusType.PENDING : StatusType.COMPLETED);
        loan.setCreatedAt(DateMethods.getActualDate());
        loan.setUpdatedAt(DateMethods.getActualDate());
        System.out.println(loanRequestDto.getIdPerson());
        loan.setPerson(
                personRepository.findById(loanRequestDto.getIdPerson())
                        .orElseThrow(() -> new RuntimeException("Error at get person to save loan")));
        loan = loanRepository.save(loan);

        return mapToDto(loan);
    }

    @Override
    public LoanResponseDto update(int id, LoanRequestDto loanRequestDto) {
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new RuntimeException("The loan with the id " + id + " does not founded"));
        loan.setDescription(loanRequestDto.getDescription());
        loan.setAmount(loanRequestDto.getAmount());
        loan.setUpdatedAt(DateMethods.getActualDate());
        loan.setStatus(loanRequestDto.getStatus() == 0 ? StatusType.PENDING : StatusType.COMPLETED);

        loan = loanRepository.save(loan);
        return mapToDto(loan);
    }

    private LoanResponseDto mapToDto(Loan loan) {
        LoanResponseDto loanResponseDto = new LoanResponseDto();
        loanResponseDto.setId(loan.getId());
        loanResponseDto.setDescription(loan.getDescription());
        loanResponseDto.setAmount(loan.getAmount());
        loanResponseDto.setStatus(StatusType.COMPLETED.equals(loan.getStatus()));
        loanResponseDto.setCreatedAt(loan.getCreatedAt());
        loanResponseDto.setUpdatedAt(loan.getUpdatedAt());

        return loanResponseDto;
    }
}
