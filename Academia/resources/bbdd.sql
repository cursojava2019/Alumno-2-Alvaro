CREATE SEQUENCE public.alumno_id_seq;

ALTER SEQUENCE public.alumno_id_seq
    OWNER TO postgres;



CREATE SEQUENCE public.profesores_id_seq;

ALTER SEQUENCE public.profesores_id_seq
    OWNER TO postgres;
    
CREATE TABLE public.alumno
(
    nombre character varying(100) COLLATE pg_catalog."default",
    apellido1 character varying(100) COLLATE pg_catalog."default",
    apellido2 character varying(100) COLLATE pg_catalog."default",
    nif character varying(9) COLLATE pg_catalog."default",
    telefono character varying(9) COLLATE pg_catalog."default",
    correo character varying(100) COLLATE pg_catalog."default",
    repetidor boolean NOT NULL,
    observaciones character varying(100) COLLATE pg_catalog."default",
    id bigint NOT NULL DEFAULT nextval('alumno_id_seq'::regclass),
    fechaalta timestamp with time zone,
    fechabaja timestamp with time zone,
    CONSTRAINT alumno_pkey PRIMARY KEY (id)
);

CREATE TABLE public.profesor
(
    id bigint NOT NULL DEFAULT nextval('profesores_id_seq'::regclass),
    nombre character varying(100) COLLATE pg_catalog."default",
    apellido1 character varying(100) COLLATE pg_catalog."default",
    apellido2 character varying(100) COLLATE pg_catalog."default",
    nif character varying(9) COLLATE pg_catalog."default",
    telefono character varying(9) COLLATE pg_catalog."default",
    correo character varying(100) COLLATE pg_catalog."default",
    titulacion character varying(100) COLLATE pg_catalog."default"
);



