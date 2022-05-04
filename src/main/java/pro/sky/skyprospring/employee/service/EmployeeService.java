package pro.sky.skyprospring.employee.service;

import pro.sky.skyprospring.employee.Employee;

public interface EmployeeService {
    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);
}
