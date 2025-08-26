package com.devsuperior.demo.controller;

import com.devsuperior.demo.dto.EmployeeDTO;
import com.devsuperior.demo.services.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<Page<EmployeeDTO>> findAll(Pageable pageable) {

        PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by("name")
        );

        return ResponseEntity.ok(employeeService.getEmployees(pageRequest));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> insert(@RequestBody EmployeeDTO dto) {
        dto = employeeService.insert(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
