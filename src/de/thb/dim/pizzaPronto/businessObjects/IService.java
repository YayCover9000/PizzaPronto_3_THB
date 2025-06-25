package de.thb.dim.pizzaPronto.businessObjects;

import de.thb.dim.pizzaPronto.valueObjects.OrderVO;

public abstract interface IService {
    public abstract String startService(OrderVO order);
}
