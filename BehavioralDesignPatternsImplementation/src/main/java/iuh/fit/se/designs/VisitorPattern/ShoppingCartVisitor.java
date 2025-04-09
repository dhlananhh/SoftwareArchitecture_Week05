package iuh.fit.se.designs.VisitorPattern;

public interface ShoppingCartVisitor {
	int visit(Book book);
    int visit(Fruit fruit);
}
