package de.thb.dim.pizzaPronto;

import java.util.Objects;

public class PastaVO extends DishVO{
    private int typeOfPasta;

    public PastaVO() {this(0, null, null, 0.00f, 0);}
    public PastaVO(int number, String name, String[] ingredients, float price, int typeOfPasta) {
        super(number, name, ingredients, price);
        setTypeOfPasta(typeOfPasta);
    }
    @Override
    public String getNameOfDish() {
        StringBuffer sb = new StringBuffer();
        sb.append("Pasta ");

        switch(typeOfPasta) {
            case 4 :
                sb.append(getName()).append(" - Spaghetti");
                break;
            case 5 :
                sb.append(getName()).append(" - Tortellini");
                break;
            case 6 :
                sb.append(getName()).append(" - Gnocchi");
                break;
            default :
                sb.append(getName());
                break;
        }

        return sb.toString();
    }
    @Override
    public int getNumberOfDish() {
        return typeOfPasta * 100 + number;
    }

    public int getTypeOfPasta() {
        return typeOfPasta;
    }

    public void setTypeOfPasta(int typeOfPasta) {
        this.typeOfPasta = typeOfPasta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PastaVO pastaVO = (PastaVO) o;
        return getTypeOfPasta() == pastaVO.getTypeOfPasta();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTypeOfPasta());
    }
}
