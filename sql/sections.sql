-- Table: public.sections

-- DROP TABLE IF EXISTS public.sections;

CREATE TABLE IF NOT EXISTS public.sections
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    course_id bigint NOT NULL DEFAULT 'nextval('sections_course_id_seq'::regclass)',
    CONSTRAINT sections_pkey PRIMARY KEY (course_id, id),
    CONSTRAINT fk7ty9cevpq04d90ohtso1q8312 FOREIGN KEY (course_id)
        REFERENCES public.courses (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.sections
    OWNER to postgres;