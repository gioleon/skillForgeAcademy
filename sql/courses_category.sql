-- Table: public.courses_category

-- DROP TABLE IF EXISTS public.courses_category;

CREATE TABLE IF NOT EXISTS public.courses_category
(
    course_entity_id bigint NOT NULL,
    category_id bigint NOT NULL,
    CONSTRAINT uk_739v5fu73ymwba3e2u8bbbtfq UNIQUE (category_id),
    CONSTRAINT fkp4yyjwyiqvop10xo0lwgixeux FOREIGN KEY (course_entity_id)
        REFERENCES public.courses (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkrahtw0d1shwuofdxjred3n9kd FOREIGN KEY (category_id)
        REFERENCES public.categories (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.courses_category
    OWNER to postgres;