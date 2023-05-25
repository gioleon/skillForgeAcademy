-- Table: public.videos

-- DROP TABLE IF EXISTS public.videos;

CREATE TABLE IF NOT EXISTS public.videos
(
    id bigint NOT NULL DEFAULT 'nextval('videos_id_seq'::regclass)',
    url_video character varying(255) COLLATE pg_catalog."default",
    tutorship_course_id bigint NOT NULL,
    tutorship_id bigint NOT NULL,
    tutorship_section_course_id bigint NOT NULL,
    tutorship_section_id bigint NOT NULL,
    CONSTRAINT videos_pkey PRIMARY KEY (id, tutorship_course_id, tutorship_id, tutorship_section_course_id, tutorship_section_id),
    CONSTRAINT uk_sfv16syrvl1fo4xrf7invdogd UNIQUE (tutorship_course_id, tutorship_id, tutorship_section_course_id, tutorship_section_id),
    CONSTRAINT fk91yoe87e7xnr44s7h7kqeu6nn FOREIGN KEY (tutorship_section_id, tutorship_section_course_id, tutorship_id, tutorship_course_id)
        REFERENCES public.tutorship (section_id, section_course_id, id, course_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.videos
    OWNER to postgres;