package org.mifosng.platform.loan.domain;


/**
 *
 */
public class LoanRepaymentScheduleTransactionProcessorFactory {

	public LoanRepaymentScheduleTransactionProcessor determineProcessor(final LoanTransactionProcessingStrategy transactionProcessingStrategy) {

		LoanRepaymentScheduleTransactionProcessor processor = new MifosStyleLoanRepaymentScheduleTransactionProcessor();
		
		if (transactionProcessingStrategy != null) {
			
			if (transactionProcessingStrategy.isStandardMifosStrategy()) {
				processor = new MifosStyleLoanRepaymentScheduleTransactionProcessor();
			}
			
			if (transactionProcessingStrategy.isHeavensfamilyStrategy()) {
				processor = new HeavensFamilyLoanRepaymentScheduleTransactionProcessor();
			}
			
			if (transactionProcessingStrategy.isCreocoreStrategy()) {
				processor = new CreocoreLoanRepaymentScheduleTransactionProcessor();
			}
			
			if (transactionProcessingStrategy.isIndianRBIStrategy()) {
				processor = new AdhikarLoanRepaymentScheduleTransactionProcessor();
			}
		}
		
		return processor;
	}
}