package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.DepartmentDTO;
import com.devsuperior.demo.entities.Department;
import com.devsuperior.demo.repositories.DepartmentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentDTO> getDepartments() {
        List<Department> list = departmentRepository.findAll(Sort.by("name"));
        return list.stream().map(DepartmentDTO::new).toList();
    }
}
