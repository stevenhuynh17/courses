package hw03;

/**
 * Returned if EmployeeDataStore is given an illegal query.
 */
public class IllegalQueryException extends IllegalArgumentException {	
	
	
	IllegalQueryException(String reason) {
        // TODO: An IllegalArgumentException can be created with a "message" or "reason" String...
		super(reason);
    }
}