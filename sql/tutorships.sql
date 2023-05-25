-- Table: public.tutorship

-- DROP TABLE IF EXISTS public.tutorship;

CREATE TABLE IF NOT EXISTS public.tutorship
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    section_course_id bigint NOT NULL,
    section_id bigint NOT NULL,
    course_id bigint NOT NULL DEFAULT 'nextval('tutorship_course_id_seq'::regclass)',
    video_id bigint,
    video_tutorship_course_id bigint,
    video_tutorship_id bigint,
    video_tutorship_section_course_id bigint,
    video_tutorship_section_id bigint,
    CONSTRAINT tutorship_pkey PRIMARY KEY (course_id, id, section_course_id, section_id),
    CONSTRAINT fkammg8horff0ldnnoikxmjhpus FOREIGN KEY (section_course_id, section_id)
        REFERENCES public.sections (course_id, id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkbkplpy96cy0vwg5fyhw9beymj FOREIGN KEY (course_id)
        REFERENCES public.courses (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkhfcvm42vf7ryydm0coyy458yd FOREIGN KEY (video_tutorship_id, video_tutorship_section_id, video_tutorship_section_course_id, video_id, video_tutorship_course_id)
        REFERENCES public.videos (tutorship_id, tutorship_section_id, tutorship_section_course_id, id, tutorship_course_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tutorship
    OWNER to postgres;