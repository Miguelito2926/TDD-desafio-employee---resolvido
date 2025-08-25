package com.devsuperior.demo.controller;

import com.devsuperior.demo.dto.DepartmentDTO;
import com.devsuperior.demo.entities.Department;
import com.devsuperior.demo.services.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAll() {
        return ResponseEntity.ok(departmentService.getDepartments());
    }
}
