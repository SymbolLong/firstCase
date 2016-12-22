package com.zhang.first.test;

import org.junit.Test;

import com.zhang.first.Customer;
import com.zhang.first.Movie;
import com.zhang.first.Rental;

public class TestCustomer {

	@Test
	public void test() {
		Movie transformer1 = new Movie("Transformers", Movie.CHILDRENS);
		Movie transformer2 = new Movie("Revenge of the Fallen", Movie.REGULAR);
		Movie transformer3 = new Movie("The Dark of the Moon", Movie.REGULAR);
		Movie transformer4 = new Movie("Age of Extinction", Movie.NEW_RELEASE);
		Rental rental1 = new Rental(transformer1, 3);
		Rental rental2 = new Rental(transformer2, 2);
		Rental rental3 = new Rental(transformer3, 5);
		Rental rental4 = new Rental(transformer4, 1);
		Customer customer = new Customer("Kent");
		customer.addRental(rental1);
		customer.addRental(rental2);
		customer.addRental(rental3);
		customer.addRental(rental4);
		String result1 = customer.statement();
		System.out.println(result1);
		String result2 = customer.statement2();
		System.out.println(result2);
		System.err.println(result1.equals(result2));
	}

}
