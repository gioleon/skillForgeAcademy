-- Table: public.comments

-- DROP TABLE IF EXISTS public.comments;

CREATE TABLE IF NOT EXISTS public.comments
(
    content character varying(255) COLLATE pg_catalog."default",
    user_id bigint NOT NULL,
    course_id bigint NOT NULL,
    CONSTRAINT comments_pkey PRIMARY KEY (course_id, user_id),
    CONSTRAINT fk7ktrfqv6fgfuw6fvwludvibu4 FOREIGN KEY (course_id)
        REFERENCES public.courses (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk8omq0tc18jd43bu5tjh6jvraq FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.comments
    OWNER to postgres;