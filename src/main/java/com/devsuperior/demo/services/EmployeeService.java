package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.EmployeeDTO;
import com.devsuperior.demo.entities.Department;
import com.devsuperior.demo.entities.Employee;
import com.devsuperior.demo.repositories.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Page<EmployeeDTO> getEmployees(Pageable pageable) {
        Page<Employee> page = employeeRepository.findAll(pageable);
       return page.map(EmployeeDTO::new);
    }

    public EmployeeDTO insert(EmployeeDTO dto) {
        Employee entity = new Employee();
        copyDtoToEntity(dto, entity);
        employeeRepository.save(entity);

        return new EmployeeDTO(entity);
    }

    private void  copyDtoToEntity(EmployeeDTO dto, Employee employee) {
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(new Department(dto.getDepartmentId(), null));
    }
}
