-- Table: public.categories

-- DROP TABLE IF EXISTS public.categories;

CREATE TABLE IF NOT EXISTS public.categories
(
    id bigint NOT NULL DEFAULT 'nextval('categories_id_seq'::regclass)',
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT categories_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.categories
    OWNER to postgres;