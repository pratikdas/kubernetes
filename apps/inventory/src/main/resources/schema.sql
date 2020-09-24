DROP TABLE IF EXISTS INVENTORY_ITEMS;
  
CREATE TABLE INVENTORY_ITEMS (
  item_id VARCHAR(50)  PRIMARY KEY,
  product_name VARCHAR(250) NOT NULL,
  items_in_stock DECIMAL(250) NOT NULL
);