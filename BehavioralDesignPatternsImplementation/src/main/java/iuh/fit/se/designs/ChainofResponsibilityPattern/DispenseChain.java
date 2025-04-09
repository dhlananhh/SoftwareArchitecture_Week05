package iuh.fit.se.designs.ChainofResponsibilityPattern;

public interface DispenseChain {
	void setNextChain(DispenseChain nextChain);

    void dispense(Currency cur);
}
