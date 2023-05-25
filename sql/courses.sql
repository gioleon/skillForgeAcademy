-- Table: public.courses

-- DROP TABLE IF EXISTS public.courses;

CREATE TABLE IF NOT EXISTS public.courses
(
    id bigint NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    owner_id bigint,
    CONSTRAINT courses_pkey PRIMARY KEY (id),
    CONSTRAINT fk3jkpttw97v8c2yuqx4prsm4m9 FOREIGN KEY (owner_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.courses
    OWNER to postgres;