-- Table: public.tokens_password_recovery

DROP TABLE IF EXISTS public.tokens_password_recovery;

CREATE TABLE IF NOT EXISTS public.tokens_password_recovery
(
    id serial,
    confirmed_at timestamp with time zone,
    created_at timestamp with time zone,
    expired_at timestamp with time zone,
    token character varying(255) COLLATE pg_catalog."default",
    user_id bigint NOT NULL,
    CONSTRAINT tokens_password_recovery_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tokens_password_recovery
    OWNER to postgres;