package com.zhang.first;

public class ChildrensPrice extends Price {

	@Override
	int getPriceCode() {
		return Movie.CHILDRENS;
	}

	@Override
	double getCharge(int daysRented) {
		double amount = 1.5;
		if (daysRented > 3) {
			amount += (daysRented - 3) * 1.5;
		}
		return amount;
	}

}
