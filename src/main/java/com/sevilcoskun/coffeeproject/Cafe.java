package com.sevilcoskun.coffeeproject;

public class Cafe {

    private int beansInStock = 0;
    private int milkInStock = 0;

    public Coffee brew(CoffeeType coffeeType){ return brew(coffeeType, 1); }

    public Coffee brew(CoffeeType coffeeType, int quantity){
        requirePositive(quantity);

        int requireBeans = coffeeType.getRequiredBeans() * quantity;
        int requiredMilk = coffeeType.getRequiredMilk() * quantity;
        if(requireBeans > beansInStock || requiredMilk > milkInStock){
            throw new IllegalStateException("Insufficient beans or milk for coffee " + coffeeType);
        }

        beansInStock -= requireBeans;
        milkInStock -= requiredMilk;
        return new Coffee(coffeeType, requireBeans, requiredMilk);
    }

    public void restockBeans(int weightInGrams){
        requirePositive(weightInGrams);
        beansInStock += weightInGrams;
    }

    public void restockMilk(int weightInGrams){
        requirePositive(weightInGrams);
        milkInStock += weightInGrams;
    }

    public void requirePositive(int value){
        if(value < 1){
            throw new IllegalArgumentException();
        }
    }

    public int getBeansInStock(){ return beansInStock; }

    public int getMilkInStock() { return milkInStock; }


}
