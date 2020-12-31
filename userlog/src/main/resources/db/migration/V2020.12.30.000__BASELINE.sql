
-- https://stackoverflow.com/questions/24923469/modeling-product-variants
-- +---------------+     +---------------+
-- | PRODUCTS      |-----< PRODUCT_SKUS  |
-- +---------------+     +---------------+
-- | #product_id   |     | #product_id   |
-- |  product_name |     | #sku_id       |
-- +---------------+     |  sku          |
--         |             |  price        |
--         |             +---------------+
--         |                     |
-- +-------^-------+      +------^------+
-- | OPTIONS       |------< SKU_VALUES  |
-- +---------------+      +-------------+
-- | #product_id   |      | #product_id |
-- | #option_id    |      | #sku_id     |
-- |  option_name  |      | #option_id  |
-- +---------------+      |  value_id   |
--         |              +------v------+
-- +-------^-------+             |
-- | OPTION_VALUES |-------------+
-- +---------------+
-- | #product_id   |
-- | #option_id    |
-- | #value_id     |
-- |  value_name   |
-- +---------------+

-- With the Primary, Unique and Foreign Keys:
--
-- PRODUCTS
-- PK: product_id
-- UK: product_name

-- OPTIONS
-- PK: product_id, option_id
-- UK: product_id, option_name

-- OPTION_VALUES
-- PK: product_id, option_id, value_id
-- UK: product_id, option_id, value_name
-- FK: product-id, option_id REFERENCES OPTIONS (product_id, option_id)

-- PRODUCT_SKUS
-- PK: product_id, sku_id
-- UK: sku_id
-- FK: product_id REFERENCES PRODUCTS (product_id)

-- SKU_VALUES
-- PK: product_id, sku_id, option_id
-- FK: product_id, sku_id REFERENCES PRODUCT_SKUS (product_id, sku_id)
-- FK: product_id, option_id REFERENCES OPTIONS (product_id, option_id)
-- FK: product_id, option_id, value_id REFERENCES OPTION_VALUES (product_id, option_id, value_id)

CREATE TABLE temp
(
    id VARCHAR(50) NOT NULL UNIQUE,
    created_by VARCHAR(100) NOT NULL,
    created_on TIMESTAMPTZ NOT NULL,
    updated_by VARCHAR(100),
    updated_on TIMESTAMPTZ,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    version BIGINT,
    CONSTRAINT transactions PRIMARY KEY (id)
);