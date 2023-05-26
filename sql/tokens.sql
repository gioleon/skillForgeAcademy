-- Table: public.tokens

-- DROP TABLE IF EXISTS public.tokens;

CREATE TABLE IF NOT EXISTS public.tokens
(
    id bigint NOT NULL DEFAULT 'nextval('tokens_id_seq'::regclass)',
    confirmed_at timestamp(6) without time zone,
    created_at timestamp(6) without time zone,
    expired_at timestamp(6) without time zone,
    token character varying(255) COLLATE pg_catalog."default",
    user_entity_id bigint,
    CONSTRAINT tokens_pkey PRIMARY KEY (id),
    CONSTRAINT fk24tjbsiiux304392fyf1kpg7e FOREIGN KEY (user_entity_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tokens
    OWNER to postgres;