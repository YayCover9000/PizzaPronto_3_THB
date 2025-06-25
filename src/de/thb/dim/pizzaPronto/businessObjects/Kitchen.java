package de.thb.dim.pizzaPronto.businessObjects;

import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoCustomerException;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
import de.thb.dim.pizzaPronto.valueObjects.ChefVO;
import de.thb.dim.pizzaPronto.valueObjects.EmployeeVO;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;
import de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO;

import java.util.Objects;

public class Kitchen implements IService{
    private EmployeeVO[] employees;

    public Kitchen() {
        this.employees = new EmployeeVO[] { new ChefVO("123", "Mertens", "Merkur") }; //ChefVO initialisieren
    }

    @Override
    public String startService(OrderVO order) throws NullPointerException, IllegalStateException{
        String s = String.format("\nService of ChefVO %s: No order available.", employees[0].getPersonnelNo());

        Objects.requireNonNull(order, s);

        if (order.getState() != StateOfOrderVO.CONFIRMED) {

            s = String.format("\nService of ChefVO %s: No order for processing available.",
                    employees[0].getPersonnelNo());
            throw new IllegalStateException(s);
        }
        else {
            order.setState(StateOfOrderVO.READY);
            s  = String.format("\nService of ChefVO %s: Order is ready.", employees[0].getPersonnelNo());
        }
        return s;
    }

    //Setter Getter

    public void setEmployees(EmployeeVO[] employees) {
        this.employees = employees;
    }

    public EmployeeVO[] getEmployees() {
        return employees;
    }
}
