package com.c0220g1.furama.controllers;

import com.c0220g1.furama.model.dto.ContractDto;
import com.c0220g1.furama.model.entity.Contract;
import com.c0220g1.furama.service.contract.IContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/contract")
@RequiredArgsConstructor
public class ContractController {
    private final IContractService contractService;

    @GetMapping("")
    public ResponseEntity<List<Contract>> getAll(){
        return ResponseEntity.ok().body(contractService.findAll());
    }
    @PostMapping("/create")
    public ResponseEntity<List<FieldError>> create(@Valid @RequestBody ContractDto contractDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        Contract contract =new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contractService.save(contract);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<List<FieldError>> update(@Valid @RequestBody ContractDto contractDto,BindingResult bindingResult,@PathVariable Long id){
        Optional<Contract> contractOptional=contractService.findById(id);
        if (!contractOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Contract contract=new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contract.setContractId(id);
        contractService.save(contract);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Optional<Contract> contractOptional=contractService.findById(id);
        if (contractOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        contractService.delete(contractOptional.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
