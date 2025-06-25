package de.thb.dim.pizzaPronto.businessObjects;

import de.thb.dim.pizzaPronto.valueObjects.ChefVO;
import de.thb.dim.pizzaPronto.valueObjects.EmployeeVO;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;
import de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO;

public class Kitchen implements IService{
    private EmployeeVO[] employees;

    public Kitchen() {
        this.employees = new EmployeeVO[] { new ChefVO("123", "Mertens", "Merkur") }; //ChefVO initialisieren
    }

    /**Change*/
    @Override
    public String startService(OrderVO order) {
        if(order == null) {
            return String.format("Service of ChefVO %s: No order available.", employees[0].getPersonnelNo());
        }else if(StateOfOrderVO.CONFIRMED.equals(order.getState())) {
            order.setState(StateOfOrderVO.READY);
            return String.format("Service of ChefVO %s: Order is ready.", employees[0].getPersonnelNo());
        } else {
            return String.format("Service of ChefVO %s: No order for processing available.", employees[0].getPersonnelNo());
            }
    }

    //Setter Getter

    public void setEmployees(EmployeeVO[] employees) {
        this.employees = employees;
    }

    public EmployeeVO[] getEmployees() {
        return employees;
    }
}
