public class Main {
    public static void main(String[] args) {

        CREATE TABLE products(
                id SERIAL primary key,
                product_name VARCHAR(50) not null,
                manufacturer VARCHAR(50) not null,
                product_count INTEGER default 0,
                price NUMERIC,
                is_discounted BOOL
);

        INSERT INTO  products(product_name,manufacturer,product_count,price,is_discounted)
        VALUES ('Iphone X','Apple',3,76000,false),
                ('Iphone 8','Apple',2,71000,true),
        ('Iphone 7','Apple',5,42000,true),
        ('Galaxy S9','Samsung',2,46000,false),
        ('Galaxy S8 Plus','Samsung',1,56000,true),
        ('Desire 12','HTC',5,28000,true),
        ('Nokia 9','HMD Global',6,38000,true);

        SELECT * FROM products WHERE manufacturer NOT LIKE 'HTC';

        SELECT * FROM products WHERE manufacturer='Apple' AND price<75000;

        SELECT * FROM products WHERE price>=46000;

        SELECT * FROM products ORDER BY price DESC LIMIT 2; /*max 2 products*/

        SELECT top 2* FROM products WHERE price=(SELECT MAX(price) FROM products); /*max 2 products*/

        SELECT product_name FROM products WHERE price =(SELECT MIN(price) FROM products);

        SELECT * FROM products WHERE is_discounted=true;

        SELECT * FROM products WHERE is_discounted=false;

        SELECT product_name,price FROM products ORDER BY price DESC;

        SELECT SUM(price) AS sum_price FROM products;

        SELECT manufacturer FROM products WHERE product_count<=2;
    }
}