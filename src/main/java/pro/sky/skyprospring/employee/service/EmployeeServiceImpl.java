package pro.sky.skyprospring.employee.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospring.employee.Employee;
import pro.sky.skyprospring.employee.exceptions.BadRequestOfEmployeeExeption;
import pro.sky.skyprospring.employee.exceptions.FullListOfEmployeeException;
import pro.sky.skyprospring.employee.exceptions.NotFoundEmployeeExeption;
import pro.sky.skyprospring.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Employee[] employees = new Employee[3];

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        boolean add = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                add = true;
                break;
            }
            if (employees[i].getFirstNameOfEmployee().equals(firstName) &&
                    employees[i].getLastNameOfEmployee().equals(lastName)) {
                throw new BadRequestOfEmployeeExeption();
            }
        }
        if (!add) {
            throw new FullListOfEmployeeException();
        }
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFirstNameOfEmployee().equals(firstName) &&
                    employees[i].getLastNameOfEmployee().equals(lastName)) {
                employee = employees[i];
                employees[i] = null;
                return employee;
            } else
                throw new NotFoundEmployeeExeption();
        }
        return null;
    }

    @Override
    public Employee find(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFirstNameOfEmployee().equals(firstName) &&
                    employees[i].getLastNameOfEmployee().equals(lastName)) {
                return employee;
            } else
                throw new NotFoundEmployeeExeption();
        }
        return null;
    }
}




