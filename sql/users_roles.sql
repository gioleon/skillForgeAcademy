-- Table: public.users_roles

-- DROP TABLE IF EXISTS public.users_roles;

CREATE TABLE IF NOT EXISTS public.users_roles
(
    user_entity_id bigint NOT NULL,
    roles_id integer NOT NULL,
    CONSTRAINT fk7v417qhe0i2m9h8njggvciv00 FOREIGN KEY (user_entity_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fka62j07k5mhgifpp955h37ponj FOREIGN KEY (roles_id)
        REFERENCES public.roles (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users_roles
    OWNER to postgres;