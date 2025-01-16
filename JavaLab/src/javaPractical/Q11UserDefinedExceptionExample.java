package javaPractical;

class InvalidAgeException extends Exception {
	public InvalidAgeException(String message) {
		super(message);
	}}

public class Q11UserDefinedExceptionExample {

	public static void main(String[] args) throws InvalidAgeException {
		int age=3;
		if(age>=18) {
			System.out.println("User can vote");
		}else {
			InvalidAgeException obj = new InvalidAgeException("User with age "+age+" cannot vote");
			throw obj;
			}
	}
}
