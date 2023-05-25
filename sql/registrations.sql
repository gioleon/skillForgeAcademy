-- Table: public.registrations

-- DROP TABLE IF EXISTS public.registrations;

CREATE TABLE IF NOT EXISTS public.registrations
(
    id bigint NOT NULL DEFAULT 'nextval('registrations_id_seq'::regclass)',
    comment_course_id bigint,
    comment_user_id bigint,
    course_id bigint,
    rate_course_id bigint,
    rate_user_id bigint,
    student_id bigint,
    CONSTRAINT registrations_pkey PRIMARY KEY (id),
    CONSTRAINT fk4qdj4hefgbyo4qbhn9espaosd FOREIGN KEY (rate_course_id, rate_user_id)
        REFERENCES public.rates (course_id, user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk9i0q5cwttb80ao05glfqr0805 FOREIGN KEY (student_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkmiqpyoqoteyx026jtiote7wdg FOREIGN KEY (comment_course_id, comment_user_id)
        REFERENCES public.comments (course_id, user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fksfbbeggcdx583ihht1yngeam6 FOREIGN KEY (course_id)
        REFERENCES public.courses (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.registrations
    OWNER to postgres;