package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.printers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.factories.SystemOutFizzBuzzOutputStrategyFactory;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies.adapters.FizzBuzzOutputStrategyToFizzBuzzExceptionSafeOutputStrategyAdapter;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.stringreturners.BuzzStringReturner;

@Service
public class BuzzPrinter {

	private final SystemOutFizzBuzzOutputStrategyFactory _systemOutFizzBuzzOutputStrategyFactory;

	/**
	 * @param _systemOutFizzBuzzOutputStrategyFactory
     */
	@Autowired
	public BuzzPrinter(final SystemOutFizzBuzzOutputStrategyFactory _systemOutFizzBuzzOutputStrategyFactory) {
		super();
		this._systemOutFizzBuzzOutputStrategyFactory = _systemOutFizzBuzzOutputStrategyFactory;
	}

	/**
	 * @return
	 */
	public void printBuzz() {
		final BuzzStringReturner myBuzzStringReturner = new BuzzStringReturner();
		final FizzBuzzOutputStrategyToFizzBuzzExceptionSafeOutputStrategyAdapter myOutputAdapter =
				new FizzBuzzOutputStrategyToFizzBuzzExceptionSafeOutputStrategyAdapter(
						this._systemOutFizzBuzzOutputStrategyFactory.createOutputStrategy());

		myOutputAdapter.output(myBuzzStringReturner.getReturnString());
	}

}
