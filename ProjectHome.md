JaQu ([Java Query](http://www.h2database.com/html/jaqu.html)) tool written by Thomas Mueller.

This version is repack for maven projects.

# Examples #

Table definition:
```
public class Product implements Table {

    public Integer productId;
    public String productName;
    public String category;
    public Double unitPrice;
    public Integer unitsInStock;

    public void define() {
        tableName("Product");
        primaryKey(productId);
        index(productName, category);
    }

}
```

DSL:
```
Product p = new Product();
List<Product> soldOutProducts =
    db.from(p).where(p.unitsInStock).is(0).select();
```