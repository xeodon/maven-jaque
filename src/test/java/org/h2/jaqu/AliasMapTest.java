/*
 * Copyright 2004-2009 H2 Group. Multiple-Licensed under the H2 License,
 * Version 1.0, and under the Eclipse Public License, Version 1.0
 * (http://h2database.com/html/license.html).
 * Initial Developer: H2 Group
 */
package org.h2.jaqu;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.List;

public class AliasMapTest {
    @Test
    public void test() throws Exception {
        Db db = Db.open("jdbc:h2:mem:", "sa", "sa");
        db.insertAll(Product.getList());

        Product p = new Product();
        List<Product> products = db
                .from(p)
                .where(p.unitsInStock).is(9)
                .orderBy(p.productId).select();

        assertEquals("[]", products.toString());
    }
}

