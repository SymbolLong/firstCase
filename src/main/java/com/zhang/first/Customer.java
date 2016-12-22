package com.zhang.first;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

	private String name;
	private Vector<Rental> rentals = new Vector<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		this.rentals.add(rental);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";
		Enumeration<Rental> elements = rentals.elements();
		while (elements.hasMoreElements()) {
			double thisAmount = 0;
			Rental current = elements.nextElement();
			switch (current.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (current.getDaysRented() > 2) {
					thisAmount += (current.getDaysRented() - 2) * 1.5;
				}
				break;
			case Movie.NEW_RELEASE:
				thisAmount += current.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (current.getDaysRented() > 3) {
					thisAmount += (current.getDaysRented() - 3) * 1.5;
				}
				break;
			default:
				break;
			}
			frequentRenterPoints++;
			if (current.getMovie().getPriceCode() == Movie.NEW_RELEASE && current.getDaysRented() > 1) {
				frequentRenterPoints++;
			}
			result += "\t" + current.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		result += "Amount owed is " + String.valueOf(totalAmount) + "\t";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

	public String statement2() {
		String result = "Rental Record for " + getName() + "\n";
		Enumeration<Rental> elements = rentals.elements();
		while (elements.hasMoreElements()) {
			Rental current = elements.nextElement();
			result += "\t" + current.getMovie().getTitle() + "\t" + String.valueOf(current.getCharge()) + "\n";
		}
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\t";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
		return result;
	}

	private int getTotalFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		Enumeration<Rental> elements = rentals.elements();
		while (elements.hasMoreElements()) {
			Rental current = elements.nextElement();
			frequentRenterPoints += current.getFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}

	private double getTotalCharge() {
		double totalAmount = 0;
		Enumeration<Rental> elements = rentals.elements();
		while (elements.hasMoreElements()) {
			Rental current = elements.nextElement();
			totalAmount += current.getCharge();
		}
		return totalAmount;
	}

}
