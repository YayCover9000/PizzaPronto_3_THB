package de.thb.dim.pizzaPronto.businessObjects;

import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoCustomerException;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;

public abstract interface IService {
    public abstract String startService(OrderVO order) throws NoCustomerException,IllegalStateException,NullPointerException;
}
