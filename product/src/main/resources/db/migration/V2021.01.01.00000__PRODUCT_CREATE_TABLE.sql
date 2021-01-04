CREATE TABLE public.products (
    id character varying(255) NOT NULL,
    created_by character varying(255) NOT NULL,
    created_on timestamp without time zone NOT NULL,
    updated_by character varying(255),
    updated_on timestamp without time zone,
    version bigint,
    brand character varying(255),
    colour character varying(255),
    description character varying(255),
    price numeric(19,2),
    title character varying(255)
);
ALTER TABLE public.products OWNER TO postgres;
ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);