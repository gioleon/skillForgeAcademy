-- Table: public.creations

-- DROP TABLE IF EXISTS public.creations;

CREATE TABLE IF NOT EXISTS public.creations
(
    id bigint NOT NULL DEFAULT 'nextval('creations_id_seq'::regclass)',
    course_id bigint,
    owner_id bigint,
    CONSTRAINT creations_pkey PRIMARY KEY (id),
    CONSTRAINT fk8rovlnagseiy5m4gr7jgb0r8o FOREIGN KEY (course_id)
        REFERENCES public.courses (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkgvv38awwh6p433mwcd7aukou0 FOREIGN KEY (owner_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.creations
    OWNER to postgres;