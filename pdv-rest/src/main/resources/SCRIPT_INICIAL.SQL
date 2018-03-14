
CREATE TABLE PDV_NEW.saa_usuario (
                usuario_id BIGINT NOT NULL,
                first_name VARCHAR(20) NOT NULL,
                last_name VARCHAR(60) NOT NULL,
                user_name VARCHAR(20) NOT NULL,
                password VARCHAR(100) NOT NULL,
                email VARCHAR(100) NOT NULL,
                token VARCHAR(100),
                tx_authorities VARCHAR(255) DEFAULT 'ADMIN'::character varying,
                bl_account_non_expired BOOLEAN DEFAULT true,
                bl_account_non_locket BOOLEAN DEFAULT true,
                bl_credential_non_expired BOOLEAN DEFAULT true,
                bl_enabled BOOLEAN DEFAULT true,
                CONSTRAINT pdv_usuario_pkey PRIMARY KEY (usuario_id)
);


CREATE TABLE PDV_NEW.pdv_produto (
                produto_id BIGINT NOT NULL,
                codigo_barra VARCHAR(15),
                estoque BIGINT,
                nome VARCHAR(100) NOT NULL,
                preco_custo NUMERIC(10,2),
                preco_venda NUMERIC(10,2) NOT NULL,
                unidade_medida INTEGER,
                CONSTRAINT pdv_produto_pkey PRIMARY KEY (produto_id)
);


CREATE TABLE PDV_NEW.pdv_movimentacao (
                movimentacao_id BIGINT NOT NULL,
                data TIMESTAMP NOT NULL,
                obs VARCHAR(100),
                numero_nota_fiscal VARCHAR(15),
                tipo_movimentacao INTEGER NOT NULL,
                CONSTRAINT pdv_movimentacao_pkey PRIMARY KEY (movimentacao_id)
);


CREATE TABLE PDV_NEW.pdv_movimentacao_produto (
                mov_pro_id BIGINT NOT NULL,
                produto_id BIGINT NOT NULL,
                movimentacao_id BIGINT NOT NULL,
                quantidade BIGINT NOT NULL,
                CONSTRAINT pdv_movimentacao_produto_pkey PRIMARY KEY (mov_pro_id, produto_id, movimentacao_id)
);


CREATE TABLE PDV_NEW.pdv_cliente (
                cliente_id BIGINT NOT NULL,
                cpf VARCHAR(11),
                rg VARCHAR(11) NOT NULL,
                endereco VARCHAR(100),
                nome VARCHAR(100) NOT NULL,
                telefone VARCHAR(30),
                data_nascimento DATE NOT NULL,
                CONSTRAINT pdv_cliente_pkey PRIMARY KEY (cliente_id)
);


CREATE TABLE PDV_NEW.pdv_caixa (
                caixa_id BIGINT NOT NULL,
                status_caixa INTEGER NOT NULL,
                total_apurado NUMERIC(10,2),
                total_fechamento NUMERIC(10,2),
                total_inicial NUMERIC(10,2) NOT NULL,
                usuario_id BIGINT NOT NULL,
                data_abertura TIMESTAMP NOT NULL,
                data_fechamento TIMESTAMP,
                CONSTRAINT pdv_caixa_pkey PRIMARY KEY (caixa_id)
);


CREATE TABLE PDV_NEW.pdv_venda (
                venda_id BIGINT NOT NULL,
                cliente_id BIGINT NOT NULL,
                caixa_id BIGINT NOT NULL,
                total NUMERIC(10,2) NOT NULL,
                descontos NUMERIC(10,2) NOT NULL,
                data DATE NOT NULL,
                CONSTRAINT pdv_venda_id_pkey PRIMARY KEY (venda_id)
);


CREATE TABLE PDV_NEW.pdv_produto_venda (
                prod_vend_id BIGINT NOT NULL,
                venda_id BIGINT NOT NULL,
                produto_id BIGINT NOT NULL,
                quantidade BIGINT NOT NULL,
                valor NUMERIC(10,2) NOT NULL,
                CONSTRAINT produto_venda_id_pkey PRIMARY KEY (prod_vend_id, venda_id, produto_id)
);


CREATE TABLE PDV_NEW.pdv_sangria (
                sangria_id BIGINT NOT NULL,
                caixa_id BIGINT NOT NULL,
                data TIMESTAMP NOT NULL,
                obs VARCHAR(100),
                valor NUMERIC(10,2),
                CONSTRAINT pdv_sangria_pkey PRIMARY KEY (sangria_id, caixa_id)
);


ALTER TABLE PDV_NEW.pdv_caixa ADD CONSTRAINT fk92jpppcw89oxbdibnopcmnrfo
FOREIGN KEY (usuario_id)
REFERENCES PDV_NEW.saa_usuario (usuario_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE PDV_NEW.pdv_movimentacao_produto ADD CONSTRAINT pdv_produto_pdv_movimentacao_produto_fk
FOREIGN KEY (produto_id)
REFERENCES PDV_NEW.pdv_produto (produto_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE PDV_NEW.pdv_produto_venda ADD CONSTRAINT pdv_produto_pdv_produto_venda_fk
FOREIGN KEY (produto_id)
REFERENCES PDV_NEW.pdv_produto (produto_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE PDV_NEW.pdv_movimentacao_produto ADD CONSTRAINT pdv_movimentacao_pdv_movimentacao_produto_fk
FOREIGN KEY (movimentacao_id)
REFERENCES PDV_NEW.pdv_movimentacao (movimentacao_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE PDV_NEW.pdv_venda ADD CONSTRAINT pdv_cliente_pdv_venda_fk
FOREIGN KEY (cliente_id)
REFERENCES PDV_NEW.pdv_cliente (cliente_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE PDV_NEW.pdv_sangria ADD CONSTRAINT pdv_caixa_pdv_sangria_fk
FOREIGN KEY (caixa_id)
REFERENCES PDV_NEW.pdv_caixa (caixa_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE PDV_NEW.pdv_venda ADD CONSTRAINT pdv_caixa_pdv_venda_fk
FOREIGN KEY (caixa_id)
REFERENCES PDV_NEW.pdv_caixa (caixa_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE PDV_NEW.pdv_produto_venda ADD CONSTRAINT pdv_venda_pdv_produto_venda_fk
FOREIGN KEY (venda_id)
REFERENCES PDV_NEW.pdv_venda (venda_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
