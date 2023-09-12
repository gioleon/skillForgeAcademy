DROP TABLE IF EXISTS public.progress_tracking;

CREATE TABLE IF NOT EXISTS public.progress_tracking
(
    id serial,
    user_id bigint NOT NULL,
    course_id bigint NOT NULL,
    class_id bigint NOT NULL,
    CONSTRAINT progress_tracking_pkey PRIMARY KEY (id),
    CONSTRAINT fk_user_progress 
        FOREIGN KEY (user_id)
            REFERENCES users(id),
    CONSTRAINT fk_course_progress 
        FOREIGN KEY (course_id)
            REFERENCES courses(id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.progress_tracking
    OWNER to postgres;