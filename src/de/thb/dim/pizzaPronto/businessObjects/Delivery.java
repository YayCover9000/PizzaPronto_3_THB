package de.thb.dim.pizzaPronto.businessObjects;

import de.thb.dim.pizzaPronto.valueObjects.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Delivery implements IService {
    private EmployeeVO[] employees;
    private Random random = new Random();

    public Delivery() {
        this.employees = new EmployeeVO[]{
                new DeliveryManVO("01","Heiner","Meiner"),
                new DeliveryManVO("02","Ralf","Randale")
        };
    }

    @Override
    public String startService(OrderVO order) {
        EmployeeVO employee = selectEmployee();

        if (order == null) {
            return String.format("Service of DeliveryManVO %s: No order available.", employee.getPersonnelNo());
        } else {
            CustomerVO customer = order.getCustomer();
            if (customer == null) {
                return String.format("Service of DeliveryManVO %s: No customer available.", employee.getPersonnelNo());
            }

            if(StateOfOrderVO.READY.equals(order.getState())) {
                order.setState(StateOfOrderVO.DELIVERED);
                return String.format("Drive to customer %s \n Service of DeliveryManVO %s: Order is delivered on %s",
                                customer, employee.toString(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' HH:mm 'o''clock'")));
            }return String.format("Service of DeliveryManVO %s: No order is ready for processing.", employee.getPersonnelNo());
        }
    }


    private EmployeeVO selectEmployee() {
        int index = random.nextInt(employees.length);
        return employees[index];
    }

    //Setter Getter

    public void setEmployees(EmployeeVO[] employees) {
        this.employees = employees;
    }

    public EmployeeVO[] getEmployees() {
        return employees;
    }
}
