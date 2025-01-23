/** Create Table **/
create table inventory (
    product_id VARCHAR NOT NULL PRIMARY KEY,
    is_active BIT NOT NULL DEFAULT 0, 
    last_updated DATE,
    metal_type VARCHAR(5),
    thickness_in FLOAT,
    thickness_mm FLOAT,
    sheet_size_WL VARCHAR(6),
    total_counts FLOAT,
    location_area VARCHAR,
    rack VARCHAR(4)
);

/** Select All **/
select * from inventory;

/** Insert Into Example **/
INSERT INTO company_inventory (product_id, is_active, last_updated, metal_type, thickness_in,
thickness_mm, sheet_size_WL, total_counts, location_area, rack)
VALUES("ss430_16", 1, "2025-01-22", "SS", 0.06, 1.5, "48x96", 38, "ITW", "ITW1");




