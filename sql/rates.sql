-- Table: public.rates

-- DROP TABLE IF EXISTS public.rates;

CREATE TABLE IF NOT EXISTS public.rates
(
    rate real NOT NULL,
    user_id bigint NOT NULL,
    course_id bigint NOT NULL,
    CONSTRAINT rates_pkey PRIMARY KEY (course_id, user_id),
    CONSTRAINT uk_ccotns49cpilfvkr5i84acs3h UNIQUE (course_id),
    CONSTRAINT uk_dllgmiddwd2cneqre3w857gv7 UNIQUE (user_id),
    CONSTRAINT fkanlgavwqngljux10mtly8qr6f FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkt5wuc6askynohbdaqeaj5wjeq FOREIGN KEY (course_id)
        REFERENCES public.courses (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.rates
    OWNER to postgres;