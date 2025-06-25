package de.thb.dim.pizzaPronto.businessObjects;

import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoCustomerException;
import de.thb.dim.pizzaPronto.valueObjects.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
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
    public  String  startService(OrderVO order) throws NoCustomerException, IllegalStateException {

        CustomerVO currentCustomer;
        EmployeeVO employee = selectEmployee();
        String s = String.format("\nService of DeliveryManVO %s: No order available.",
                employee.getPersonnelNo());
        Objects.requireNonNull(order, s);

        currentCustomer = order.getCustomer();

        if (currentCustomer == null) {
            s = String.format("\nService of DeliveryManVO %s: No customer available.", employee.getPersonnelNo());
            throw new NoCustomerException(s);
        }

        if (order.getState() == StateOfOrderVO.READY) {

            order.setState(StateOfOrderVO.DELIVERED);
            s += String.format("\nDrive to customer  %s %s, in %s %s\n", currentCustomer.getLastName(),
                    currentCustomer.getFirstName(), currentCustomer.getStreet(),
                    currentCustomer.getHouseNumber());
            s += String.format(
                    "\nService of DeliveryManVO %s: ",
                    employee.getPersonnelNo());
            s += String.format(
                    "Order is delivered on %1$tm/%1$td/%1$tY at %1$tH:%1$tM o'clock",
                    LocalDateTime.now());

        } else {
            s = String.format("\nService of DeliveryManVO %s: No order is ready for processing.",
                    employee.getPersonnelNo());
            throw new IllegalStateException(s);
        }
        return s;
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
