package iuh.fit.se.designs.StatePattern;

public class TVStartState implements State {
	@Override
	public void doAction() {
		System.out.println("TV is turned ON");
	}
}
