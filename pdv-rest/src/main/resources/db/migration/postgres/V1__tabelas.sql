CREATE TABLE public.pdv_cliente
(
  cliente_id bigint NOT NULL,
  cpf character varying(255),
  datanascimento bytea,
  endereco character varying(255),
  nome character varying(255) NOT NULL,
  telefone character varying(255),
  data_nascimento bytea,
  CONSTRAINT pdv_cliente_pkey PRIMARY KEY (cliente_id)
)
WITH (
  OIDS=FALSE;
);
ALTER TABLE public.pdv_cliente
  OWNER TO root;




CREATE TABLE public.pdv_caixa
(
  caixa_id bigint NOT NULL,
  dataabertura bytea NOT NULL,
  datafechamento bytea NOT NULL,
  statuscaixa integer NOT NULL,
  totalapurado numeric(10,2),
  totalfechamento numeric(10,2),
  totalinicial numeric(10,2) NOT NULL,
  data_abertura bytea NOT NULL,
  data_fechamento bytea NOT NULL,
  status_caixa integer NOT NULL,
  total_apurado numeric(10,2),
  total_fechamento numeric(10,2),
  total_inicial numeric(10,2) NOT NULL,
  CONSTRAINT pdv_caixa_pkey PRIMARY KEY (caixa_id)
)
WITH (
  OIDS=FALSE;
);
ALTER TABLE public.pdv_caixa
  OWNER TO root;



CREATE TABLE public.pdv_produto
(
  produto_id bigint NOT NULL,
  codigo_barra character varying(255),
  estoque bigint,
  nome character varying(255) NOT NULL,
  preco_custo numeric(10,2),
  preco_venda numeric(10,2) NOT NULL,
  unidade_medida integer,
  CONSTRAINT pdv_produto_pkey PRIMARY KEY (produto_id)
)
WITH (
  OIDS=FALSE;
);
ALTER TABLE public.pdv_produto
  OWNER TO root;



CREATE TABLE public.pdv_sangria
(
  sangria_id bigint NOT NULL,
  data bytea NOT NULL,
  obs character varying(100),
  valor numeric(10,2),
  caixa_id bigint,
  CONSTRAINT pdv_sangria_pkey PRIMARY KEY (sangria_id),
  CONSTRAINT fkdht6e80u18qn2stw8210055t6 FOREIGN KEY (caixa_id)
      REFERENCES public.pdv_caixa (caixa_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE;
);
ALTER TABLE public.pdv_sangria
  OWNER TO root;


CREATE TABLE public.pdv_movimentacao
(
  movimentacao_id bigint NOT NULL,
  data bytea NOT NULL,
  numeronotafiscal character varying(15),
  obs character varying(100),
  tipomovimentacao integer NOT NULL,
  numero_nota_fiscal character varying(15),
  tipo_movimentacao integer NOT NULL,
  CONSTRAINT pdv_movimentacao_pkey PRIMARY KEY (movimentacao_id)
)
WITH (
  OIDS=FALSE;
);


CREATE TABLE public.pdv_movimentacao_produto
(
  mov_pro_id bigint NOT NULL,
  quantidade bigint NOT NULL,
  produto_id bigint,
  CONSTRAINT pdv_movimentacao_produto_pkey PRIMARY KEY (mov_pro_id),
  CONSTRAINT fknwnnrharq5v46do1qpc08vy1j FOREIGN KEY (produto_id)
      REFERENCES public.pdv_produto (produto_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE;
);
ALTER TABLE public.pdv_movimentacao_produto
  OWNER TO root;



