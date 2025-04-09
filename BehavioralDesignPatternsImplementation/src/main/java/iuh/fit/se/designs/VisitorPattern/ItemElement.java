package iuh.fit.se.designs.VisitorPattern;

public interface ItemElement {
	public int accept(ShoppingCartVisitor visitor);
}
